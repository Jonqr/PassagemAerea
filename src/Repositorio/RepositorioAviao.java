/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Model.Aviao;
import Model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonh_
 */
public class RepositorioAviao {
    
    private List<Aviao> avioes;
    private static RepositorioAviao instance = null;
    
    
    private RepositorioAviao() {
        avioes = new ArrayList<Aviao>();
    }
           
     public static RepositorioAviao getInstance() {
        if(instance == null) instance = new RepositorioAviao();
        return instance;
    }
     
    public boolean add(Aviao aviao){
        return(avioes.add(aviao));
    }
    
    public boolean estaVazio(){
        return avioes.isEmpty();
    }
    public int getQtdAssentos(Aviao cod){
        return cod.getQtdAssentos();
    }
    public List<Aviao> getAviao() {
        return avioes;
    }
    
    public Aviao aviaoExiste(String cod){
        
        for(Aviao aviao: avioes){
            if(aviao.getCódigo().equals(cod)){
                return aviao;
            }
        }
    
        return null;
    }
    
    public Aviao buscarAviao(String cod){
        for(Aviao aviao: avioes){
            if(aviao.getCódigo().equals(cod)){
                return aviao;
            }
        }
    
        return null;
    }
    
    
    
 
    
}//fim da classe 
