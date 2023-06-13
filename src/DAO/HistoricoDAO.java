package DAO;





public class HistoricoDAO {
    

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
