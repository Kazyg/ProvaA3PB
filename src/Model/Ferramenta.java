
package Model;
public class Ferramenta {
    private String id;
    private String nome;
    private String marca;
    private String custo;
    // Construtores vazio 
    public Ferramenta() {
    }
    // Construtores com atributos
    public Ferramenta(String id, String nome, String marca, String custo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
    }
    // Construtores get e set
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }
}
