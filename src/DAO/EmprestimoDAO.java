package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Emprestimo;
import View.MensagensException;
import java.util.Date;

public class EmprestimoDAO {

    private ArrayList<Emprestimo> listaEmprestimo
            = new ArrayList<>();

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
            String password = "admin";

            conn = DriverManager.getConnection(url,
                    user, password);
        } catch (SQLException erro) {
            erro.printStackTrace();
        } catch (ClassNotFoundException erro) {
            erro.printStackTrace();
        }
        return conn;
    }

    public ArrayList<Emprestimo> getMinhaLista() throws MensagensException, SQLException {

        listaEmprestimo.clear(); // Limpa nosso ArrayList

        Statement stmt = this.getConnection().createStatement();
        ResultSet res
                = stmt.executeQuery("SELECT idemprestimo, dataEmprestimo, dataEntregaPrevista "
                        + "FROM tb_Emprestimo;");
        while (res.next()) {

            int id = res.getInt("idemprestimo");
            Date dataRetirada = res.getDate("dataEmprestimo");
            Date dataPrevistaDevolucao = res.getDate("dataEntregaPrevista");
            Emprestimo objeto = new Emprestimo(id, dataRetirada, dataPrevistaDevolucao);

            listaEmprestimo.add(objeto);
        }

        stmt.close();
        return listaEmprestimo;

    }

    public boolean InsertEmprestimoBD(int id, Date dataRetirada, Date dataPrevistaDevolucao) throws MensagensException, SQLException {
        Emprestimo objeto = new Emprestimo(id, dataRetirada, dataPrevistaDevolucao);
        String sql = "INSERT INTO "
                + "emprestimo (idemprestimo, dataEmprestimo, dataEntregaPrevista)"
                + "VALUES(?,?,?)";

        PreparedStatement stmt = this.getConnection().prepareStatement(sql);

        stmt.setInt(1, objeto.getId());
        stmt.setDate(2, (java.sql.Date) objeto.getDataRetirada());
        stmt.setDate(3, (java.sql.Date) objeto.getDataPrevistaDevolucao());

        stmt.execute();
        stmt.close();
        return true;

    }

    public Emprestimo carregaEmprestimo(int id) throws SQLException, MensagensException {
        Emprestimo objeto = new Emprestimo();

        Statement stmt = this.getConnection().createStatement();
        ResultSet res = stmt.executeQuery("SELECT * "
                + "FROM tb_emprestimo WHERE idemprestimo = " + id);
        res.next();

        objeto.setId(res.getInt("idemprestimo"));
        objeto.setDataRetirada(res.getDate("dataEmprestimo"));
        objeto.setDataPrevistaDevolucao(res.getDate("dataEntregaPrevista"));

        stmt.close();

        return objeto;
    }
}
