package DAO;

import Model.Amigo;
import Model.Emprestimo;
import Model.Ferramenta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Historico;
import Model.HistoricoPersonalizado;
import View.MensagensException;
import java.util.Date;

public class HistoricoDAO {

    private ArrayList<Historico> listaHistorico
            = new ArrayList<>();
    private ArrayList<HistoricoPersonalizado> listaHistoricoPersonalizado
            = new ArrayList<>();
    private final AmigoDAO amigoDAO = new AmigoDAO();
    private final FerramentaDAO ferramentaDAO = new FerramentaDAO();
    private final EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

    public Connection getConnection() {
        Connection conn = null;

        try {
            // Carregamento do JDBC Driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            // Configurar a conexão
            String server = "localhost"; //caminho do MySQL
            String database = "provaa3";
            String url = "jdbc:mysql://" + server
                    + ":3306/" + database
                    + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "suaSenha";

            conn = DriverManager.getConnection(url,
                    user, password);
        } catch (SQLException erro) {
            erro.printStackTrace();
        } catch (ClassNotFoundException erro) {
            erro.printStackTrace();
        }
        return conn;
    }

    public ArrayList<Historico> getMinhaLista() throws MensagensException, SQLException {

        listaHistorico.clear();

        Statement stmt = this.getConnection().createStatement();
        ResultSet res
                = stmt.executeQuery("SELECT idhistorico, amigo_idamigo, "
                        + "ferramenta_idferramenta, emprestimo_idemprestimo, dataEntregaEfetiva  "
                        + "FROM tb_historico;");
        while (res.next()) {

            int id = res.getInt("idhistorico");
            Amigo amigo = amigoDAO.carregaAmigo(res.getInt("amigo_idamigo"));
            Ferramenta ferramenta = ferramentaDAO.carregaFerramenta(res.getInt("ferramenta_idferramenta"));
            Emprestimo emprestimo = emprestimoDAO.carregaEmprestimo(res.getInt("emprestimo_idemprestimo"));
            Date dataEfetivaDevolucao = res.getDate("dataEntregaEfetiva");
            if (res.wasNull()) {
                dataEfetivaDevolucao = null;
            }
            Historico objeto = new Historico(id, amigo, ferramenta, emprestimo, dataEfetivaDevolucao);

            listaHistorico.add(objeto);
        }

        stmt.close();
        return listaHistorico;

    }

    public boolean InsertHistoricoBD(int id, Amigo amigo, Ferramenta ferramenta, Emprestimo emprestimo, Date dataEfetivaDevolucao) throws MensagensException, SQLException {
        Historico objeto = new Historico(id, amigo, ferramenta, emprestimo, dataEfetivaDevolucao);
        String sql = "INSERT INTO "
                + "tb_historico(idhistorico, amigo_idamigo, ferramenta_idferramenta, emprestimo_idemprestimo, dataEntregaEfetiva) "
                + "VALUES(?,?,?,?,?)";

        PreparedStatement stmt = this.getConnection().prepareStatement(sql);

        stmt.setInt(1, objeto.getId());
        stmt.setInt(2, objeto.getAmigo().getId());
        stmt.setInt(3, objeto.getFerramenta().getId());
        stmt.setInt(4, objeto.getEmprestimo().getId());
        stmt.setDate(5, (java.sql.Date) objeto.getDataEfetivaDevolucao());

        stmt.execute();
        stmt.close();
        return true;

    }

    public ArrayList<HistoricoPersonalizado> getMinhaListaPersonalizada(int idRecebido) throws MensagensException, SQLException {

        listaHistoricoPersonalizado.clear();

        Statement stmt = this.getConnection().createStatement();
        ResultSet res;
        if (idRecebido < 0) {
            res
                    = stmt.executeQuery("SELECT\n"
                            + "  idhistorico, nome, nomeFerramenta, marca, idemprestimo, dataEntregaPrevista, dataEmprestimo, dataEntregaEfetiva\n"
                            + "FROM\n"
                            + "  provaa3.tb_historico\n"
                            + "JOIN\n"
                            + "  tb_amigo ON tb_historico.amigo_idamigo = tb_amigo.idamigo\n"
                            + "JOIN\n"
                            + "  tb_ferramenta ON tb_historico.ferramenta_idferramenta = tb_ferramenta.idferramenta\n"
                            + "JOIN\n"
                            + "  tb_emprestimo ON tb_historico.emprestimo_idemprestimo = tb_emprestimo.idemprestimo");
        } else {
            res
                    = stmt.executeQuery("SELECT\n"
                            + "  idhistorico, nome, nomeFerramenta, marca, idemprestimo, dataEntregaPrevista, dataEmprestimo, dataEntregaEfetiva\n"
                            + "FROM\n"
                            + "  provaa3.tb_historico\n"
                            + "JOIN\n"
                            + "  tb_amigo ON tb_historico.amigo_idamigo = tb_amigo.idamigo\n"
                            + "JOIN\n"
                            + "  tb_ferramenta ON tb_historico.ferramenta_idferramenta = tb_ferramenta.idferramenta\n"
                            + "JOIN\n"
                            + "  tb_emprestimo ON tb_historico.emprestimo_idemprestimo = tb_emprestimo.idemprestimo "
                            + "where idamigo = " + idRecebido);
        }
        while (res.next()) {

            int idHistorico = res.getInt("idhistorico");
            String nomeAmigo = res.getString("nome");
            String nomeFerramenta = res.getString("nomeFerramenta");
            String marcaFerramenta = res.getString("marca");
            int idEmprestimo = res.getInt("idemprestimo");
            Date dataEmprestimo = res.getDate("dataEmprestimo");
            Date dataPrevistaDevolucao = res.getDate("dataEntregaPrevista");
            Date dataEfetivaDevolucao = res.getDate("dataEntregaEfetiva");
            if (res.wasNull()) {
                dataEfetivaDevolucao = null;
            }
            HistoricoPersonalizado objeto = new HistoricoPersonalizado(idHistorico, nomeAmigo, nomeFerramenta, marcaFerramenta, idEmprestimo, dataEmprestimo, dataPrevistaDevolucao, dataEfetivaDevolucao);

            listaHistoricoPersonalizado.add(objeto);
        }

        stmt.close();
        return listaHistoricoPersonalizado;

    }

    public boolean AlterarHistoricoBD(int id, Amigo amigo, Ferramenta ferramenta, Emprestimo emprestimo, Date dataEfetivaDevolucao) throws MensagensException, SQLException {

        java.util.Date utilDate = dataEfetivaDevolucao; // seu objeto java.util.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        Historico objeto = new Historico(id, amigo, ferramenta, emprestimo, sqlDate);

        String sql = "UPDATE tb_historico set dataEntregaEfetiva = ? "
                + "WHERE idhistorico = ?";

        PreparedStatement stmt = this.getConnection().prepareStatement(sql);

        stmt.setDate(1, (java.sql.Date) objeto.getDataEfetivaDevolucao());
        stmt.setInt(2, objeto.getId());

        stmt.execute();
        stmt.close();
        return true;
    }
}
