/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presenter;

import Dao.ClienteDAO;
import java.util.List;
import ufes.sqllitedao.model.Cliente;

/**
 *
 * @author batis
 */
public class GerenciadorClienteService {

   private ClienteDAO clienteDAO;

   public GerenciadorClienteService(ClienteDAO clienteDAO) {
       this.clienteDAO = clienteDAO;
   }


   public void adicionarCliente(String nome, String email) {
       Cliente cliente = new Cliente();
       cliente.setNome(nome);
       cliente.setEmail(email);
       clienteDAO.inserir(cliente);
   }

   public List<Cliente> listarClientes() {
       return clienteDAO.listarTodos();
   }

   public Cliente buscarClientePorId(int id) {
       return clienteDAO.buscarPorId(id);
   }

   public void atualizarCliente(Cliente cliente) {
       clienteDAO.atualizar(cliente);
   }

   public void deletarCliente(int id) {
       clienteDAO.deletar(id);
   }
}


