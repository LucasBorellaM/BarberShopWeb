package data;

/**
 *
 * @author lucas
 */
public class Clientes {
    private int id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String telefone;

    public Clientes(int id, String nome, String cpf, String dataNascimento, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public Clientes() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Clientes: " +
           "id = " + id +
           ", nome = " + nome +
           ", cpf = " + cpf +
           ", dataNascimento = " + dataNascimento + 
           ", telefone = " + telefone +
           ".\n";
    }

}
