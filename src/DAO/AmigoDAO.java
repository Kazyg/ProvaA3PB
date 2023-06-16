package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Amigo;
import View.MensagensException;

public class AmigoDAO extends BaseDAO{

    private ArrayList<Amigo> listaAmigo
            = new ArrayList<>();

    public ArrayList<Amigo> getMinhaLista() throws MensagensException, SQLException {

        listaAmigo.clear(); // Limpa nosso ArrayList

        Statement stmt = super.getConnection().createStatement();
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

        PreparedStatement stmt = super.getConnection().prepareStatement(sql);

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

        Statement stmt = super.getConnection().createStatement();
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

