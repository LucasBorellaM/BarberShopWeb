package data;

/**
 *
 * @author lucas
 */
public class Servicos {
    private int id;
    private String nome;
    private Double valorCusto;
    private Double valorCobrado;

    public Servicos(int id, String nome, Double valorCusto, Double valorCobrado) {
        this.id = id;
        this.nome = nome;
        this.valorCusto = valorCusto;
        this.valorCobrado = valorCobrado;
    }

    public Servicos() {
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

    public Double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(Double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public Double getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(Double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    @Override
    public String toString() {
        return "Serviços: " +
           "id = " + id +
           ", nome = " + nome +
           ", valor de custo = " + valorCusto +
           ", valor cobrado = " + valorCobrado + 
           ".\n";
    }

}
