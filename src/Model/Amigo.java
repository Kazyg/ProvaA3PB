package Model;

public class Amigo {

    private int id;
    private String nome;
    private String telefone;
    private String email;

    // Construtores vazio    
    public Amigo() {
    }

    public Amigo(int id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    // Construtores com atributos
    public Amigo(String nome, String telefone, String email) {
        this.id = 0;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

}
