/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import daos.ClienteDAO;
import entidades.Cliente;
import java.util.ArrayList;

/**
 *
 * @author romulo
 */
public class CriarClienteAction extends ActionSupport {
    
    private String nome;
    private String email;
    
    private ArrayList<Cliente> clientes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
 
    @Override
    public String execute() throws Exception {
        ClienteDAO cDAO = new ClienteDAO();
        Cliente cliente = new Cliente(nome, email);
        int resultado = cDAO.criarCliente(cliente);
        if (resultado == 1) {
            clientes = cDAO.obterClientes();
            return SUCCESS;
        }
        return ERROR;
    }
    
}
