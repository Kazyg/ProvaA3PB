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

public class FerramentaDAO extends BaseDAO{

    private ArrayList<Ferramenta> listaFerramenta
            = new ArrayList<>();

    public ArrayList<Ferramenta> getMinhaLista() throws MensagensException, SQLException {

        listaFerramenta.clear(); // Limpa nosso ArrayList

        Statement stmt = super.getConnection().createStatement();
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

        PreparedStatement stmt = super.getConnection().prepareStatement(sql);

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

        Statement stmt = super.getConnection().createStatement();
        ResultSet res = stmt.executeQuery("SELECT * "
                + "FROM tb_ferramenta WHERE idferramenta = " + id);
        res.next();

        objeto.setId(res.getInt("idferramenta"));
        objeto.setNome(res.getString("nomeFerramenta"));
        objeto.setMarca(res.getString("marca"));
        objeto.setCusto(res.getDouble("custo"));

        stmt.close();

        return objeto;
    }

    public boolean DeleteFerramentaBD(int id) throws SQLException {
        Statement stmt = null;
        try {
            stmt = this.getConnection().createStatement();
            int rowsAffected = stmt.executeUpdate("DELETE FROM tb_ferramenta WHERE idferramenta = " + id);
            return rowsAffected > 0;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
    
    public boolean AlterarFerramentaBD(int id, String nome, String marca, double custo) throws MensagensException, SQLException {

        Ferramenta objeto = new Ferramenta(nome, marca, custo);

        String sql = "UPDATE tb_ferramenta set nomeFerramenta = ?, "
                + "marca = ?, custo = ? WHERE idferramenta = ?";

        PreparedStatement stmt = super.getConnection().prepareStatement(sql);

        stmt.setString(1, objeto.getNome());
        stmt.setString(2, objeto.getMarca());
        stmt.setDouble(3, objeto.getCusto());
        stmt.setInt(4, id);

        stmt.execute();
        stmt.close();
        return true;
    }
}
