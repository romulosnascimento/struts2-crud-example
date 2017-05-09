/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import daos.ClienteDAO;
import entidades.Cliente;
import java.util.ArrayList;
/**
 *
 * @author leoomoreira
 */
public class ListarClientesAction extends ActionSupport {

    private ArrayList<Cliente> clientes;

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
 
    @Override
    public String execute() throws Exception {
        ClienteDAO cDAO = new ClienteDAO();
        clientes = cDAO.obterClientes();
        return SUCCESS;
    }

}
