/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonh_
 */
public class RepositorioCliente {
    
    private List<Cliente> clientes;
    private static RepositorioCliente instance = null;
    
    private RepositorioCliente() {
        clientes = new ArrayList<Cliente>();
    }
    
    
     public static RepositorioCliente getInstance() {
        if(instance == null) instance = new RepositorioCliente();
        return instance;
    }
    
    

    public boolean add(Cliente cliente) {
        return (clientes.add(cliente));
    }
    
    public boolean estaVazio(){
        return clientes.isEmpty();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Cliente clienteExiste(String rg) {
        for (Cliente cliente : clientes) {
            if (cliente.getRG().equals(rg)) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente buscarCliente(String rg) {
        for (Cliente cliente : clientes) {
            if (cliente.getRG().equals(rg)) {
                return cliente;
           }
        }
        return null;
    }
    
    
        
    
}// fim da classe
