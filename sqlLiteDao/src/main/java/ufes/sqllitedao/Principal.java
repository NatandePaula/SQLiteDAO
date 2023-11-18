/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ufes.sqllitedao;

import Dao.ClienteDAO;
import Dao.ClienteDAOSQLite;
import static Dao.Connect.connect;
import java.util.List;
import presenter.GerenciadorClienteService;
import ufes.sqllitedao.model.Cliente;

/**
 *
 * @author batis
 */
public class Principal {
   public static void main(String[] args) {
       connect();

   ClienteDAO clienteDAO = new ClienteDAOSQLite();
       GerenciadorClienteService gerenciadorClientes = new GerenciadorClienteService(clienteDAO);
       // Adicionando clientes
       gerenciadorClientes.adicionarCliente("João Silva", "joao.silva@email.com");
       gerenciadorClientes.adicionarCliente("Maria Pereira", "maria.pereira@email.com");

       // Listando todos os clientes
       List<Cliente> clientes = gerenciadorClientes.listarClientes();
       System.out.println("Clientes cadastrados:");
       for (Cliente cliente : clientes) {
           System.out.println(cliente.getId() 
+ " - " + cliente.getNome() + " - " + cliente.getEmail());
       }
      Cliente clienteEncontrado = gerenciadorClientes.buscarClientePorId(1);
       if (clienteEncontrado != null) {
           System.out.println("Cliente encontrado: " 
+ clienteEncontrado.getNome());
       } else {
           System.out.println("Cliente não encontrado.");
       }

       // Atualizando informações do cliente
       Cliente clienteParaAtualizar = 
new Cliente(2, "João Carlos Silva", "joao.silva@email.com");
       gerenciadorClientes.atualizarCliente(clienteParaAtualizar);

       // Deletando cliente pelo ID
       gerenciadorClientes.deletarCliente(2);
  }
}


