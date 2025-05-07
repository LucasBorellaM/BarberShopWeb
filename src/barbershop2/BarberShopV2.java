package barbershop2;

import dao.DAOFactory;
import data.Agendamentos;
import data.Clientes;
import data.Funcionarios;
import data.Servicos;

/**
 *
 * @author lucas
 */
public class BarberShopV2 {

    public static void main(String[] args) {
        
        //Funcionarios
        Funcionarios f1 = new Funcionarios(1, "Jose", "123.123.123-22", "22/02/2020", "(55)98298-1123");
        DAOFactory.getFuncionarioDao().inserir(f1);

        //Clientes
        Clientes c1 = new Clientes(1, "Julio", "122.116.553-16", "02/09/2003", "(55)9349-1764");
        Clientes c2 = new Clientes(2, "Marcia", "155.131.887-12", "13/07/1999", "(55)9654-8712");
        DAOFactory.getClienteDao().inserir(c1);
        DAOFactory.getClienteDao().inserir(c2);

        //Serviços
        Servicos s1 = new Servicos(1, "corte", 25.0, 40.0);
        Servicos s2 = new Servicos(2, "barba", 15.0, 30.0);
        DAOFactory.getServicoDao().inserir(s1);
        DAOFactory.getServicoDao().inserir(s2);

        //Agendamentos
        Agendamentos a1 = new Agendamentos(0, "11/02/2025-13:30", s1, f1, c1, "pix");
        Agendamentos a3 = new Agendamentos(5, "11/02/2025-14:00", s2, f1, c2, "cartão");
        DAOFactory.getAgendamentoDao().inserir(a1);
        DAOFactory.getAgendamentoDao().inserir(a3);
        
        Double total = DAOFactory.getAgendamentoDao().calcularTotal(DAOFactory.getAgendamentoDao().listar());
        System.out.println("Total = "+ total );
        System.out.println("Listando os agendamentos: \n"+ DAOFactory.getAgendamentoDao().listar());
        System.out.println("Buscando por ID: "+ DAOFactory.getClienteDao().buscaPorId(2));
        
    }
    
}
