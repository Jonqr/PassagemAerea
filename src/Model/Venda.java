package Model;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import util.DateTimeUtil;

/**
 *
 * @author jonh_
 */
public class Venda {
    
    private LocalDateTime DataCompra;
    private Cliente cliente;
    private Voo Voo;
    private String codVenda;
    private final int qtdUsado = 1 ;
    /*
    Venda de passagens: registra uma venda, relacionando o cliente, vôo e a data/hora da compra (LocalDateTime), realizando o controle da quantidade de assentos.
    */
    public void registraVenda(Cliente cli, Voo cad, String Cod){
  
        this.cliente = cli;
        this.Voo = cad;
        this.DataCompra = LocalDateTime.now();     
        this.codVenda = Cod;     
    }
    
    public String getCodVenda() {
        return codVenda;
    } 
    public LocalDateTime getDataCompra() {
        return DataCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public Voo getVoo() {
        return Voo;
    }

    @Override
    public String toString() {
        return "Venda{" + "DataCompra=" + DataCompra + ", cliente=" + cliente + ", Voo=" + Voo + ", codVenda=" + codVenda  + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
}


   
        
    
    



