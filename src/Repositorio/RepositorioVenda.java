/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Model.CadVoo;
import Model.Cliente;
import Model.Venda;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jonh_
 */
public class RepositorioVenda {
    
    private List<Venda> venda;
    private static RepositorioVenda instace = null;
    
    private RepositorioVenda(){
    
        venda = new ArrayList<Venda>();
    }
    
    public static RepositorioVenda getInstance(){
        if(instace == null) instace = new RepositorioVenda();
        return instace;
    }
    
       
    public boolean add(Venda vendac) {
        return (venda.add(vendac));
    }
       
    public boolean estaVazio(){
        return venda.isEmpty();
    }

    public List<Venda> getVenda() {
        return venda;
    }
    
    
        
    public void getQtdAssento(Venda venc){
        int qtd =0;
        qtd = venc.getQtdAssento();
        qtd = qtd - venda.size();
        int qtd2 = venda.size();
        qtd2 = qtd - qtd2;
        
        System.out.println("Assentos Disponiveis: "+ qtd);
        System.out.println("Assentos ocupados: "+qtd2);
        
    }
    public Venda VendaExiste(String cod) {
        for (Venda ve : venda) {
            if (ve.getCodVenda().equals(cod)) {
                return ve;
            }
        }
        return null;
    }
    
    
    
    public Venda buscarVenda(String cod) {
        for (Venda ve : venda) {
            if (ve.getCodVenda().equals(cod)) {
                return ve;
            }
        }
        return null;
    }
    
    
    
}
