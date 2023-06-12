package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Ferramenta;
import View.MensagensException;

public class FerramentaDAO {
    private ArrayList<Ferramenta> listaFerramenta
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
            String password = "xtprox0123456";

            conn = DriverManager.getConnection(url,
                    user, password);
        } catch (SQLException erro) {
            erro.printStackTrace();
        } catch (ClassNotFoundException erro) {
            erro.printStackTrace();
        }
        return conn;
    }

    public ArrayList<Ferramenta> getMinhaLista() throws MensagensException, SQLException {

        listaFerramenta.clear(); // Limpa nosso ArrayList

        Statement stmt = this.getConnection().createStatement();
        ResultSet res
                = stmt.executeQuery("SELECT idferramenta, nomeFerramenta, "
                        + "marca, custo "
                        + "FROM tb_ferramenta;");
        while (res.next()) {
            
            int id = res.getInt("idFerramenta");
            String nome = res.getString("nomeFerramenta");
            String marca = res.getString("marca");
            double custo = res.getDouble("custo");
            Ferramenta objeto = new Ferramenta(id, nome, marca, custo);

            listaFerramenta.add(objeto);
        }

        stmt.close();
        return listaFerramenta;

    }

    public boolean InsertFerramentaBD(int id, String nome, String marca, double custo) throws MensagensException, SQLException {
        Ferramenta objeto = new Ferramenta(id, nome, marca, custo);
        String sql = "INSERT INTO "
                + "tb_ferramenta(idferramenta, nomeFerramenta, marca, custo) "
                + "VALUES(?,?,?,?)";

        PreparedStatement stmt = this.getConnection().prepareStatement(sql);

        stmt.setInt(1, objeto.getId());
        stmt.setString(2, objeto.getNome());
        stmt.setString(3, objeto.getMarca());
        stmt.setDouble(4, objeto.getCusto());

        stmt.execute();
        stmt.close();
        return true;

    }

    public Ferramenta carregaFerramenta(int id) throws SQLException, MensagensException {
        Ferramenta objeto = new Ferramenta();

        Statement stmt = this.getConnection().createStatement();
        ResultSet res = stmt.executeQuery("SELECT * "
                + "FROM tb_ferramenta WHERE idferramenta = " + id);
        res.next();

        objeto.setId(res.getInt("idferramenta"));
        objeto.setNome(res.getString("nome"));
        objeto.setMarca(res.getString("marca"));
        objeto.setCusto(res.getDouble("custo"));

        stmt.close();

        return objeto;
    }
}
