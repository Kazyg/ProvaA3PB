package Model;

import java.util.ArrayList;
import java.util.List;


public class Historico {
    private int id;
    private Amigo amigo;
    private List<Ferramenta> listaFerramentas;
    private Emprestimo emprestimo;

    public Historico(Amigo amigo, List<Ferramenta> listaFerramentas, Emprestimo emprestimo) {
        this.id = 0;
        this.amigo = amigo;
        this.listaFerramentas = new ArrayList<>();
        this.emprestimo = emprestimo;
    }
    
    
    public Amigo getAmigo() {
        return amigo;
    }

    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }

    public List<Ferramenta> getListaFerramentas() {
        return listaFerramentas;
    }

    public void setListaFerramentas(List<Ferramenta> listaFerramentas) {
        this.listaFerramentas = listaFerramentas;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
    
}
