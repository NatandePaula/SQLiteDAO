/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Dao;

import static Dao.CriacaoDasTabelas.createNewTable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author batis
 */
public class Connect {
     /**
     * Connect to a sample database
     */
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:meuBancoDeDados.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Conectado com o banco de dados.");
            
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        createNewTable();
        
    }
    /**
     * @param args the command line arguments
     */
  
//    public static void main(String[] args) {
//        connect();
//    }
}