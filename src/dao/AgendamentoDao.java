/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import persistencia.ConexaoBanco;
import data.Agendamentos;
import data.Clientes;
import data.Funcionarios;
import data.Servicos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class AgendamentoDao implements GenericoDao<Agendamentos> {

    @Override
    public void inserir(Agendamentos agendamento) {
        String sql = "INSERT INTO agendamentos VALUES(default,?,?,?,?,?)";
        try(Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) { 
            
            ps.setString(1, agendamento.getDataAgendamento());
            ps.setInt(2, agendamento.getServico().getId());
            ps.setInt(3, agendamento.getFuncionario().getId());
            ps.setInt(4, agendamento.getCliente().getId());
            ps.setString(5, agendamento.getTipoPagamento());
            
            ps.executeUpdate();
            System.out.println("Agendamento inserido.");
            con.close();
            
        }catch(SQLException e){
            throw new RuntimeException("Erro ao salvar o agendamento "+ e.getMessage());
        }
    }

    @Override
    public void atualizar(Agendamentos agendamento) {
        String sql = "UPDATE agendamentos SET dataAgendamento =?, servico_id =?, funcionario_id =?, cliente_id =?, tipoPagamento =? WHERE id =?";
        try(Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, agendamento.getDataAgendamento());
            ps.setInt(2, agendamento.getServico().getId());
            ps.setInt(3, agendamento.getFuncionario().getId());
            ps.setInt(4, agendamento.getCliente().getId());
            ps.setString(5, agendamento.getTipoPagamento());
            ps.setInt(6, agendamento.getId());
            
            ps.executeUpdate();
            System.out.println("Agendamento atualizado.");
            con.close();
            
        }catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar o agendamento "+ e.getMessage());
        }
    }

    @Override
    public void deletar(Integer id) {
        String sql = "DELETE FROM agendamentos WHERE id =?";
        try(Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.execute();
            System.out.println("Agendamento deletado.");
            con.close();
            
        }catch(SQLException e){
            throw new RuntimeException("Erro ao deletar o agendamento "+ e.getMessage());
        }
    }

    @Override
    public List<Agendamentos> listar() {
        String sql = "SELECT * FROM agendamentos";
        List<Agendamentos> agendamentosLista = new ArrayList<>();
        try(Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Agendamentos agend = new Agendamentos();
                
                agend.setId(rs.getInt("id"));
                agend.setDataAgendamento(rs.getString("dataAgendamento"));
                int servicoId = rs.getInt("servico_id");
                int funcionarioId = rs.getInt("funcionario_id");
                int clienteId = rs.getInt("cliente_id");

                ServicoDao servDao = new ServicoDao();
                Servicos serv = servDao.buscaPorId(servicoId);

                FuncionarioDao funcDao = new FuncionarioDao();
                Funcionarios func = funcDao.buscaPorId(funcionarioId);

                ClienteDao cliDao = new ClienteDao();
                Clientes cli = cliDao.buscaPorId(clienteId);

                agend.setServico(serv);
                agend.setCliente(cli);
                agend.setFuncionario(func);
                agend.setTipoPagamento(rs.getString("tipoPagamento"));
                agendamentosLista.add(agend);
            }
            
        }catch(SQLException e){
            System.out.println("Falha ao listar agendamentos: "+ e.getMessage());
            return null;
        }
        return agendamentosLista;
    }

    @Override
    public Agendamentos buscaPorId(Integer id) {
        String sql = "SELECT * FROM agendamentos WHERE id= ?";
        List<Agendamentos> agendamentosLista = new ArrayList<>();
        try(Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Agendamentos agend = new Agendamentos();

                agend.setId(rs.getInt("id"));
                agend.setDataAgendamento(rs.getString("dataAgendamento"));
                
                int servicoId = rs.getInt("servico_id");
                int funcionarioId = rs.getInt("funcionario_id");
                int clienteId = rs.getInt("cliente_id");

                Servicos serv = new Servicos();
                serv.setId(servicoId);
                Funcionarios func = new Funcionarios();
                func.setId(funcionarioId);
                Clientes cli = new Clientes();
                cli.setId(clienteId);

                agend.setServico(serv) ;
                agend.setFuncionario(func);
                agend.setCliente(cli);
                
                agend.setTipoPagamento(rs.getString("tipoPagamento"));

                agendamentosLista.add(agend);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar agendamento: " + e.getMessage());
        }
        return (Agendamentos) agendamentosLista;
    } 
    
    public double calcularTotal(List<Agendamentos> agend){
        double total = 0.0;
        
        for(Agendamentos agendamento: agend){
            total += agendamento.getServico().getValorCobrado(); 
        }
        return total;
    }
    
}
