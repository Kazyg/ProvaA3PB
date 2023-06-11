package Model;

import java.util.*;

public class Emprestimo {

    private int Id;
    private Date DataPrevistaDevolucao;
    private Date DataRetirada;
    private Date DataEfetivaDevolucao;

    public Emprestimo() {
    }

    public Emprestimo(Date DataPrevistaDevolucao, Date DataRetirada, Date DataEfetivaDevolucao) {
        this.Id = 0;
        this.DataPrevistaDevolucao = DataPrevistaDevolucao;
        this.DataRetirada = DataRetirada;
        this.DataEfetivaDevolucao = DataEfetivaDevolucao;
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

    public Date getDataEfetivaDevolucao() {
        return DataEfetivaDevolucao;
    }

    public void setDataDevolucao(Date DataDevolucao) {
        this.DataEfetivaDevolucao = DataDevolucao;
    }

}
