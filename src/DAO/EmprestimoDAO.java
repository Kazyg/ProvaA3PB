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

public class EmprestimoDAO extends BaseDAO{

    private ArrayList<Emprestimo> listaEmprestimo
            = new ArrayList<>();

    public ArrayList<Emprestimo> getMinhaLista() throws MensagensException, SQLException {

        listaEmprestimo.clear(); // Limpa nosso ArrayList

        Statement stmt = super.getConnection().createStatement();
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

    public int InsertEmprestimoBD(int id, Date dataRetirada, Date dataPrevistaDevolucao) throws MensagensException, SQLException {
        Emprestimo objeto = new Emprestimo(id, dataPrevistaDevolucao, dataRetirada);
        String sql = "INSERT INTO "
                + "tb_emprestimo(idemprestimo, dataEmprestimo, dataEntregaPrevista) "
                + "VALUES(?,?,?)";

        PreparedStatement stmt = super.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1, objeto.getId());
        stmt.setDate(2, (java.sql.Date) objeto.getDataRetirada());
        stmt.setDate(3, (java.sql.Date) objeto.getDataPrevistaDevolucao());

        stmt.execute();
        ResultSet rs = stmt.getGeneratedKeys();
        int idGerado = 0;
        if (rs.next()) {
            idGerado = rs.getInt(1);
        }
        stmt.close();
        return idGerado;

    }

    public Emprestimo carregaEmprestimo(int id) throws SQLException, MensagensException {
        Emprestimo objeto = new Emprestimo();

        Statement stmt = super.getConnection().createStatement();
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
