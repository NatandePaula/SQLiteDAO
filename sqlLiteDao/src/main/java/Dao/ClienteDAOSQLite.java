/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ufes.sqllitedao.model.Cliente;

/**
 *
 * @author batis
 */
public class ClienteDAOSQLite implements ClienteDAO {
  private Connection connection;

  public ClienteDAOSQLite() {
    try {
      connection = DriverManager.getConnection("jdbc:sqlite:meuBancoDeDados.db");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  // Implementação dos métodos inserir, buscarPorId, listarTodos, atualizar e deletar

    

    @Override
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO Clientes (name, email) VALUES (?,?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            //pstmt.setInt(1, cliente.getId());
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEmail());

            pstmt.executeUpdate();

            System.out.println("Cliente inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    @Override
    public Cliente buscarPorId(int id) {
            String sql = "SELECT * FROM Clientes WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("name"));
                cliente.setEmail(rs.getString("email"));

                return cliente;
            } else {
                System.out.println("Cliente com ID " + id + " não encontrado.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente por ID: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Cliente> listarTodos() {
        List<Cliente> listaClientes = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("name"));
                cliente.setEmail(rs.getString("email"));
                listaClientes.add(cliente);
            }

            System.out.println("Lista de clientes obtida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }

        return listaClientes;
    }

    @Override
    public void atualizar(Cliente cliente) {
        String sql = "UPDATE Clientes SET name = ?, email = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setString(1, cliente.getNome());
        pstmt.setString(2, cliente.getEmail());
        pstmt.setInt(3, cliente.getId());

        int linhasAfetadas = pstmt.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Nenhum cliente encontrado com o ID fornecido.");
        }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
        
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM Clientes WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Cliente deletado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar cliente: " + e.getMessage());
        }
    }
}

