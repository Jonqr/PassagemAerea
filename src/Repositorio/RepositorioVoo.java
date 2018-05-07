/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Model.Aviao;
import Model.Voo;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jonh_
 */
public class RepositorioVoo {
    private List<Voo> cadastroVoo;
    private static RepositorioVoo instance = null;
    
    private RepositorioVoo(){
        
        cadastroVoo = new ArrayList<Voo>();
    }
    
    public static RepositorioVoo getInstance(){
        if(instance == null) instance = new RepositorioVoo();
        return instance;
    }
   
    public boolean add(Voo cd){
        
        return(cadastroVoo.add(cd));
    } 
    
    public boolean estaVazio(){
        return cadastroVoo.isEmpty();
    }
    
    public List<Voo> getVoo(){
        return cadastroVoo;
    }
    
    public List<Voo> getDatas(){
        Collections.sort(cadastroVoo);
        return cadastroVoo;
    }    
    
    
    public Voo VooExiste(String cod){
        
        for(Voo cadv: cadastroVoo){
            if(cadv.getCodVoo().equals(cod)){
            return cadv;
            }
        }
        return null;
    }
    
    public Voo buscarVoo(String cod){
        for(Voo cadv: cadastroVoo){
            if(cadv.getCodVoo().equals(cod)){
            return cadv;
            }
        }
        return null;
    }
   
    
    
}
