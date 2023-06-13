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
import View.MensagensException;
import java.util.Date;

public class HistoricoDAO {

    private ArrayList<Historico> listaHistorico
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

        listaHistorico.clear(); // Limpa nosso ArrayList

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
}
