package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonh_
 */
public class Venda {
    
    private LocalDateTime DataCompra;
    private Cliente cliente;
    private CadVoo cadastro;
    private int qtdAssento = cadastro.getQtdAssento();
    private String codVenda;
    /*
    Venda de passagens: registra uma venda, relacionando o cliente, vôo e a data/hora da compra (LocalDateTime), realizando o controle da quantidade de assentos.
    */
    public void registraVenda(Cliente cli, CadVoo cad, String Cod){
        try{
        this.cliente = cli;
        this.cadastro = cad;
        this.DataCompra = LocalDateTime.now();
        this.codVenda = Cod;   
        
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("ERRO NA EXECUÇÃO!!!");
        }
       
    }

    public String getCodVenda() {
        return codVenda;
    }

    public int getQtdAssento() {
        return qtdAssento;
    }

    public LocalDateTime getDataCompra() {
        return DataCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public CadVoo getCadastro() {
        return cadastro;
    }
    
    
    
    
    
    
    
    
    
}


   
        
    
    



