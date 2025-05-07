package dao;

/**
 *
 * @author lucas
 */
public class DAOFactory {
    
    private static final ClienteDao clienteDao = new ClienteDao();
    private static final FuncionarioDao funcionarioDao = new FuncionarioDao();
    private static final ServicoDao servicoDao = new ServicoDao();
    private static final AgendamentoDao agendamentoDao = new AgendamentoDao();
    
    
    public static ClienteDao getClienteDao(){
        return clienteDao;
    }
    
    public static FuncionarioDao getFuncionarioDao(){
        return funcionarioDao;
    }
    
    public static ServicoDao getServicoDao(){
        return servicoDao;
    }
    
    public static AgendamentoDao getAgendamentoDao(){
        return agendamentoDao;
    }
    
}
