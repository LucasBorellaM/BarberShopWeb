package dao;

import persistencia.ConexaoBanco;
import data.Clientes;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author lucas
 */
public class ClienteDao implements GenericoDao<Clientes> {
   
    @Override
    public void inserir(Clientes cliente) {
        String sql = "INSERT INTO clientes VALUES (default,?,?,?,?)";
        try(Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getDataNascimento());
            ps.setString(4, cliente.getTelefone());
            
            ps.executeUpdate();
            System.out.println("Cliente inserido.");
            
        }catch(SQLException e){
            throw new RuntimeException("Erro ao salvar o cliente "+ e.getMessage());
        } 
        
    }

    @Override
    public void atualizar(Clientes cliente) {
        String sql = "UPDATE clientes SET nome =?, cpf =?, dataNascimento =?, telefone =? WHERE id =?";
        try(Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {
 
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getDataNascimento());
            ps.setString(4, cliente.getTelefone());
            ps.setInt(5, cliente.getId());
            
            ps.executeUpdate();
            System.out.println("Cliente atualizado.");
            
        }catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar o cliente "+ e.getMessage());
        }
        
    }

    @Override
    public void deletar(Integer id) {
        String sql = "DELETE FROM clientes WHERE id =?";
        try(Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.execute();
            System.out.println("Cliente deletado.");
            
        }catch(SQLException e){
           throw new RuntimeException("Erro ao deletar o cliente "+ e.getMessage());
        }
        
    }

    @Override
    public List<Clientes> listar() {
        String sql = "SELECT * FROM clientes";
        try(Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ResultSet rs = ps.executeQuery();
            
            List<Clientes> clientesLista = new ArrayList<>();
            while(rs.next()){
                Clientes cliente = new Clientes();
                
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setDataNascimento(rs.getString("dataNascimento"));
            cliente.setTelefone(rs.getString("telefone"));
            clientesLista.add(cliente);
            }
            return clientesLista;
            
        }catch(SQLException e){
            throw new RuntimeException("Erro ao listar os clientes "+ e.getMessage());
        }  
    }

    @Override
    public Clientes buscaPorId(Integer id) {
        String sql = "SELECT * FROM clientes WHERE id =?";
        try(Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Clientes clie = new Clientes();
                
                clie.setId(rs.getInt("id"));
                clie.setNome(rs.getString("nome"));
                clie.setCpf(rs.getString("cpf"));
                clie.setDataNascimento(rs.getString("dataNascimento"));
                clie.setTelefone(rs.getString("telefone"));
                return clie;
            }
        }catch(SQLException e){
            throw new RuntimeException("Erro ao buscar o cliente pelo id "+ e.getMessage());
        }
        return null;
        
    }
    
}
