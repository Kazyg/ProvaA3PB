package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Amigo;
import View.MensagensException;

public class AmigoDAO {

    private ArrayList<Amigo> listaAmigo
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

    public ArrayList<Amigo> getMinhaLista() throws MensagensException, SQLException {

        listaAmigo.clear(); // Limpa nosso ArrayList

        Statement stmt = this.getConnection().createStatement();
        ResultSet res
                = stmt.executeQuery("SELECT idamigo, nome, "
                        + "telefone, email "
                        + "FROM tb_amigo;");
        while (res.next()) {
            
            int id = res.getInt("idamigo");
            String nome = res.getString("nome");
            String telefone = res.getString("telefone");
            String email = res.getString("email");
            Amigo objeto = new Amigo(id, nome, telefone, email);

            listaAmigo.add(objeto);
        }

        stmt.close();
        return listaAmigo;

    }

    public boolean InsertAmigoBD(int id, String nome, String telefone, String email) throws MensagensException, SQLException {
        Amigo objeto = new Amigo(id, nome, telefone, email);
        String sql = "INSERT INTO "
                + "tb_amigo(idamigo, nome, telefone, email) "
                + "VALUES(?,?,?,?)";

        PreparedStatement stmt = this.getConnection().prepareStatement(sql);

        stmt.setInt(1, objeto.getId());
        stmt.setString(2, objeto.getNome());
        stmt.setString(3, objeto.getTelefone());
        stmt.setString(4, objeto.getEmail());

        stmt.execute();
        stmt.close();
        return true;

    }

    public Amigo carregaAmigo(int id) throws SQLException, MensagensException {
        Amigo objeto = new Amigo();

        Statement stmt = this.getConnection().createStatement();
        ResultSet res = stmt.executeQuery("SELECT * "
                + "FROM tb_amigo WHERE idamigo = " + id);
        res.next();

        objeto.setId(res.getInt("idamigo"));
        objeto.setNome(res.getString("nome"));
        objeto.setTelefone(res.getString("telefone"));
        objeto.setEmail(res.getString("email"));

        stmt.close();

        return objeto;
    }
}

