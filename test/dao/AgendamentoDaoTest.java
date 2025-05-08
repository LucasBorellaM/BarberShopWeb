package dao;

import data.Agendamentos;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucas
 */
public class AgendamentoDaoTest {
    AgendamentoDao agendDao = new AgendamentoDao();
    
    public AgendamentoDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of testPossuiCadastros method, of class AgendamentoDao.
     */
    @Test
    public void testPossuiCadastros() {
        assertTrue(agendDao.listar().size() > 1);
    }

    /**
     * Test of testClienteAgendado method, of class AgendamentoDao.
     */
    @Test
    public void testClienteAgendado() {
        List<Agendamentos> list = agendDao.listar();
        Agendamentos agend = new Agendamentos();
        agend = list.get(0);
        assertEquals("Julio", agend.getCliente().getNome());
    }
    
    /**
     * Test of testFuncionarioAgendado method, of class AgendamentoDao.
     */
    @Test
    public void testFuncionarioAgendado() {
        List<Agendamentos> list = agendDao.listar();
        Agendamentos agend = new Agendamentos();
        agend = list.get(0);
        assertEquals("Jose", agend.getFuncionario().getNome());
    }

    /**
     * Test of testServicoAgendado method, of class AgendamentoDao.
     */
    @Test
    public void testServicoAgendado() {
        List<Agendamentos> list = agendDao.listar();
        Agendamentos agend = new Agendamentos();
        agend = list.get(0);
        assertEquals("corte", agend.getServico().getNome());
    }
    
    /**
     * Test of testServicoValor method, of class AgendamentoDao.
     */
    @Test
    public void testServicoValor() {
        List<Agendamentos> list = agendDao.listar();
        Agendamentos agend = new Agendamentos();
        agend = list.get(1);
        double valorTest = 15.0;
        double valorCusto = agend.getServico().getValorCusto();
        assertTrue(valorTest == valorCusto);
    }

    /**
     * Test of testCalcularTotal method, of class AgendamentoDao.
     */
    @Test
    public void testCalcularTotal() {
        System.out.println("calcularTotal");
        List<Agendamentos> list = agendDao.listar();
        double result = agendDao.calcularTotal(list);
        double valorTest = 70.0;
        assertTrue(result == valorTest);
    }
  
}
