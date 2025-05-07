package dao;

import java.util.List;

/**
 *
 * @author lucas
 * @param <T>
 */
public interface GenericoDao<T> {
    void inserir(T obj);
    void atualizar(T obj);
    void deletar(Integer id);
    List<T> listar();
    T buscaPorId(Integer id);

}
