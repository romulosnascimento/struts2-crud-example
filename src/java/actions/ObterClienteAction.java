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
 * @author leoomoreira
 */
public class ObterClienteAction extends ActionSupport {

    private int clienteId;
    private Cliente cliente;

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public String execute() throws Exception {
        ClienteDAO cDAO = new ClienteDAO();
        cliente = cDAO.obterCliente(clienteId);
        return SUCCESS;
    }

}
