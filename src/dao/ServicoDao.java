/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import persistencia.ConexaoBanco;
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
public class ServicoDao implements GenericoDao<Servicos> {

    @Override
    public void inserir(Servicos servico) {
        String sql = "INSERT INTO servicos VALUES (default,?,?,?)";
        try(Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {
           
            ps.setString(1, servico.getNome());
            ps.setDouble(2, servico.getValorCusto());
            ps.setDouble(3, servico.getValorCobrado());
            
            ps.executeUpdate();
            System.out.println("Serviço inserido.");
            con.close();
            
        }catch(SQLException e){
            throw new RuntimeException("Erro ao salvar o servico "+ e.getMessage());
        }
    }

    @Override
    public void atualizar(Servicos servico) {
        String sql = "UPDATE servicos SET nome =?, valorCusto =?, valorCobrado =? WHERE id =?";
        try(Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, servico.getNome());
            ps.setDouble(2, servico.getValorCusto());
            ps.setDouble(3, servico.getValorCobrado());
            ps.setInt(4, servico.getId());
            
            ps.executeUpdate();
            System.out.println("Serviço atualizado.");
            con.close();
            
        }catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar o servico "+ e.getMessage());
        }
    }

    @Override
    public void deletar(Integer id) {
        String sql = "DELETE FROM servicos WHERE id =?";
        try(Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.execute();
            System.out.println("Serviço deletado.");
            con.close();
            
        }catch(SQLException e){
            throw new RuntimeException("Erro ao excluir o servico "+ e.getMessage());
        }
    }

    @Override
    public List<Servicos> listar() {
        String sql = "SELECT * FROM servicos"; 
        try(Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {
 
            ResultSet rs = ps.executeQuery();
            
            List<Servicos> servicosLista = new ArrayList<>();
            while(rs.next()){
                Servicos servico = new Servicos();
                
                servico.setId(rs.getInt("id"));
                servico.setNome(rs.getString("nome"));
                servico.setValorCusto(rs.getDouble("valorCusto"));
                servico.setValorCobrado(rs.getDouble("valorCobrado"));
                servicosLista.add(servico);
            }
            return servicosLista;
            
        }catch(SQLException e){
            throw new RuntimeException("Erro ao listar os servicos "+ e.getMessage());
        }
    }

    @Override
    public Servicos buscaPorId(Integer id) {
        String sql = "SELECT * FROM servicos WHERE id =?";
        try(Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Servicos serv = new Servicos();
                
                serv.setId(rs.getInt("id"));
                serv.setNome(rs.getString("nome"));
                serv.setValorCusto(rs.getDouble("valorCusto"));
                serv.setValorCobrado(rs.getDouble("valorCobrado"));
                return serv;
            }
        }catch(SQLException e){
            throw new RuntimeException("Erro ao buscar os servicos por id "+ e.getMessage());
        }
        return null;
    }

}
