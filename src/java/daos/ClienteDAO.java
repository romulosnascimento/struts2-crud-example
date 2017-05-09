/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author romulo
 */
public class ClienteDAO {
    
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/schema";
    
    private final String USUARIO = "usuario";
    private final String SENHA = "senha";
    
    private Connection conn;
    private Statement stmt;
    
    public ClienteDAO() {}
    
    public ArrayList<Cliente> obterClientes() {
        
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        try {
            conn = conectarAoBancoDeDados();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM cliente";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                clientes.add(new Cliente(id, nome, email));
            }
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clientes;
    
    }
    
    public int criarCliente(Cliente cliente) {
        
        int rs = 0;
        
        try {
            conn = conectarAoBancoDeDados();
            stmt = conn.createStatement();
            String sql = "INSERT INTO cliente (id, nome, email) VALUES (NULL, '" + cliente.getNome() + "', '" + cliente.getEmail() + "');";
            rs = stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }

    public Cliente obterCliente(int clienteId) {
        
        Cliente cliente = null;
        
        try {
            conn = conectarAoBancoDeDados();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM cliente WHERE id = " + clienteId + " LIMIT 1";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                cliente = new Cliente(id, nome, email);
            }
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cliente;
    }

    public int atualizarCliente(Cliente cliente) {
        
        int rs = 0;
        
        try {
            conn = conectarAoBancoDeDados();
            stmt = conn.createStatement();
            String sql = "UPDATE cliente SET nome = '" + cliente.getNome() + "', email = '" + cliente.getEmail() + "' WHERE id = " + cliente.getId();
            rs = stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }

    public int deletarCliente(int clienteId) {
        int rs = 0;
        
        try {
            conn = conectarAoBancoDeDados();
            stmt = conn.createStatement();
            String sql = "DELETE FROM cliente WHERE id = " + clienteId;
            rs = stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    private Connection conectarAoBancoDeDados() {
    try {
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL, USUARIO, SENHA);
            return connection;
            
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
