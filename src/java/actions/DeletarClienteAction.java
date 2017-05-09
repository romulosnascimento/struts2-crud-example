/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import daos.ClienteDAO;
import entidades.Cliente;
import java.util.ArrayList;

/**
 *
 * @author romulo
 */
public class DeletarClienteAction extends ActionSupport {
    
    private int clienteId;
    private ArrayList<Cliente> clientes;

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
 
    @Override
    public String execute() throws Exception {
        System.out.println(clienteId);
        ClienteDAO cDAO = new ClienteDAO();
        int resultado = cDAO.deletarCliente(clienteId);
        if (resultado == 1) {
            clientes = cDAO.obterClientes();
            return SUCCESS;
        }
        return ERROR;
    }
    
}
