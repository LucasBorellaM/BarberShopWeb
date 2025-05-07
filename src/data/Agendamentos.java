package data;

/**
 *
 * @author lucas
 */
public class Agendamentos {
    private int id;
    private String dataAgendamento;
    private Servicos servico;
    private Funcionarios funcionario;
    private Clientes cliente;
    private String tipoPagamento;

    public Agendamentos(int id, String dataAgendamento, Servicos servico, Funcionarios funcionario, Clientes cliente, String tipoPagamento) {
        this.id = id;
        this.dataAgendamento = dataAgendamento;
        this.servico = servico;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.tipoPagamento = tipoPagamento;
    }

    public Agendamentos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(String dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Servicos getServico() {
        return servico;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
    }

    public Funcionarios getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionarios funcionario) {
        this.funcionario = funcionario;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    
    @Override
    public String toString() {
        return "Agendamentos: " +
           "id = " + id +
           ", data do agendamento = " + dataAgendamento +
           ", Serviço = " + servico.getNome() +
           ", Funcionário = " + funcionario.getNome() + 
           ", Cliente = " + cliente.getNome() +
           ", tipo do pagamento = "+ tipoPagamento +     
           ".\n";
    }
    
}
