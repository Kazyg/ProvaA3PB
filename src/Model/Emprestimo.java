package Model;

import java.util.*;

public class Emprestimo {

    private int Id;
    private Date DataPrevistaDevolucao;
    private Date DataRetirada;

    public Emprestimo() {
    }

    public Emprestimo(int Id, Date DataPrevistaDevolucao, Date DataRetirada) {
        this.Id = Id;
        this.DataPrevistaDevolucao = DataPrevistaDevolucao;
        this.DataRetirada = DataRetirada;
    }
    
    public Emprestimo(Date DataPrevistaDevolucao, Date DataRetirada) {
        this.Id = 0;
        this.DataPrevistaDevolucao = DataPrevistaDevolucao;
        this.DataRetirada = DataRetirada;
    }

    public Date getDataPrevistaDevolucao() {
        return DataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(Date DataPrevistaDevolucao) {
        this.DataPrevistaDevolucao = DataPrevistaDevolucao;
    }

    public Date getDataRetirada() {
        return DataRetirada;
    }

    public void setDataRetirada(Date DataRetirada) {
        this.DataRetirada = DataRetirada;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
}
