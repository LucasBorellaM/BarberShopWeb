package dao;

import persistencia.ConexaoBanco;
import data.Funcionarios;
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
public class FuncionarioDao implements GenericoDao<Funcionarios> {

    @Override
    public void inserir(Funcionarios funcionario) {
        String sql = "INSERT INTO funcionarios VALUES (default,?,?,?,?)";
        try(Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, funcionario.getNome());
                ps.setString(2, funcionario.getCpf());
                ps.setString(3, funcionario.getDataNascimento());
                ps.setString(4, funcionario.getTelefone());

                ps.executeUpdate();
                System.out.println("Funcionario inserido.");
                con.close();
                
        }catch(SQLException e){
            throw new RuntimeException("Erro ao salvar o funcionario "+ e.getMessage());
        }
    }

    @Override
    public void atualizar(Funcionarios funcionario) {
        String sql = "UPDATE funcionarios SET nome =?, cpf =?, dataNascimento =?, telefone =? WHERE id =?";
        try(Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getDataNascimento());
            ps.setString(4, funcionario.getTelefone());
            ps.setInt(5, funcionario.getId());
            
            ps.executeUpdate();
            System.out.println("Funcionario atualizado.");
            con.close();
            
        }catch(SQLException e){
            throw new RuntimeException("Erro ao atualizar o funcionario "+ e.getMessage());
        }
    }

    @Override
    public void deletar(Integer id) {
        String sql = "DELETE FROM funcionarios WHERE id = ?";
        
        try (Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Funcionario deletado.");
            con.close();
            
        }catch(SQLException e){
            throw new RuntimeException("Erro ao deletar o funcionario "+ e.getMessage());
        }
    }

    @Override
    public List<Funcionarios> listar() {
        String sql = "SELECT * FROM funcionarios";
        try (Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            
            List<Funcionarios> funcionariosLista = new ArrayList<>();
            while(rs.next()){
                Funcionarios funcionario = new Funcionarios();
                
            funcionario.setId(rs.getInt("id"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setCpf(rs.getString("cpf"));
            funcionario.setDataNascimento(rs.getString("dataNascimento"));
            funcionario.setTelefone(rs.getString("telefone"));
            funcionariosLista.add(funcionario);
            }
            return funcionariosLista;
            
        }catch(SQLException e){
            throw new RuntimeException("Erro ao listar os funcionarios "+ e.getMessage());
        }  
    }

    @Override
    public Funcionarios buscaPorId(Integer id) {
        String sql = "SELECT * FROM funcionarios WHERE id =?";
        try(Connection con = ConexaoBanco.getConection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Funcionarios funcionario = new Funcionarios();
                
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setDataNascimento(rs.getString("dataNascimento"));
                funcionario.setTelefone(rs.getString("telefone"));
                return funcionario;
            }
        }catch(SQLException e){
            throw new RuntimeException("Erro ao buscar o funcionario por id "+ e.getMessage());
        }
        return null;
        
    }
    
}
