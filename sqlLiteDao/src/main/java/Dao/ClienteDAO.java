/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

/**
 *
 * @author batis
 */
import java.util.List;
import ufes.sqllitedao.model.Cliente;
public interface ClienteDAO {
   void inserir(Cliente cliente);
   Cliente buscarPorId(int id);
   List<Cliente> listarTodos();
   void atualizar(Cliente cliente);
   void deletar(int id);
}
