package Model;

import java.util.*;

public class Emprestimo {
    private int Id;
    private String NomeAmigo;
    private String NomeFerramenta;
    private Date DataRetirada;
    private Date DataDevolucao;
    
    public Emprestimo(){
}
    public Emprestimo (int Id, String NomeAmigo, String NomeFerramenta, Date DataRetirada, Date DataDevolucao){
        this.Id = Id;
        this.NomeAmigo = NomeAmigo;
        this.NomeFerramenta = NomeFerramenta;
        this.DataRetirada = DataRetirada;
        this.DataDevolucao = DataDevolucao;
}

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNomeAmigo() {
        return NomeAmigo;
    }

    public void setNomeAmigo(String NomeAmigo) {
        this.NomeAmigo = NomeAmigo;
    }

    public String getNomeFerramenta() {
        return NomeFerramenta;
    }

    public void setNomeFerramenta(String NomeFerramenta) {
        this.NomeFerramenta = NomeFerramenta;
    }

    public Date getDataRetirada() {
        return DataRetirada;
    }

    public void setDataRetirada(Date DataRetirada) {
        this.DataRetirada = DataRetirada;
    }

    public Date getDataDevolucao() {
        return DataDevolucao;
    }

    public void setDataDevolucao(Date DataDevolucao) {
        this.DataDevolucao = DataDevolucao;
    }

    

            
    
}
