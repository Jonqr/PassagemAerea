/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Model.Aviao;
import Model.Voo;
import Model.Cliente;
import Model.Venda;
import Repositorio.RepositorioCliente;
import Repositorio.RepositorioVenda;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import util.Console;
import util.DateTimeUtil;
import util.StringUtils;

/**
 *
 * @author jonh_
 */
public class PassagemAerea {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcao = 0;
        do {

            try {
                System.out.println("\nSISTEMA DE COMPRA DE PASSAGENS: ");
                System.out.println("Selecione uma opção: ");
                System.out.println("1- Adicionar Cliente");
                System.out.println("2- Adicionar Avião");
                System.out.println("3- Cadastrar Voo");
                System.out.println("4- Listar Clientes");
                System.out.println("5- Listar Aviões");  
                System.out.println("6- Listar Vôos Cadastrados");
                System.out.println("7- Criar Venda");
                System.out.println("8- Relatorio de Venda");
                System.out.println("0- Sair");
                opcao = Console.scanInt("Digite a opcao: ");
                
                
                    switch (opcao) {
                    case 1:
                        adicionarCliente();
                        break;
                    case 2: 
                        adicionarAviao();
                        break;
                    case 3:
                        cadastrarVoo();
                        break;
                    case 4: 
                        listarClientes();
                        break;
                    case 5:
                        listarAvioes();
                        break;
                    case 6:
                        ListarCadastrovoo();
                        break;
                    case 7: 
                        Venda();
                        break;
                    case 8:
                        Relatorio();
                        break;
                    case 0:
                        System.out.println("Saindo do Sistema...");
                        break;
                    default:
                        System.err.println("Erro: Escolha a opcao correta!!");
                }
                
                
            } catch (InputMismatchException e) {
                System.err.println("Erro: Escolha a opcao correta!");
            }
        } while (opcao != 0);
            
    }

    //RG, nome, telefone
    private static void adicionarCliente() {
        System.out.println("\nAdicionando Cliente...");
        try {
            String rg,nome,telefone;
            
            do{
             rg = Console.scanString("RG: ");
            }while(StringUtils.isNullOrBlank(rg)==true||StringUtils.isNullOrEmpty(rg)==true );
            do{
             nome = Console.scanString("Nome: ");
            }while(StringUtils.isNullOrBlank(nome)==true||StringUtils.isNullOrEmpty(nome)==true );
            telefone = Console.scanString("Telefone: ");

            if(RepositorioCliente.getInstance().clienteExiste(rg) == null){
            Cliente cliente = new Cliente(rg, nome, telefone);
            RepositorioCliente.getInstance().add(cliente);
            System.out.println("Cadastro  de cliente realizado com sucesso!");
            } else {
                System.err.println("ERRO: CLIENTE EXISTENTE ! ... TENTE NOVAMENTE");
                adicionarCliente();
            }
               
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Erro: informe dados corretos!");      
        }
            
   
    }
    
    private static void adicionarAviao(){
        System.out.println("\n --Adicionando Aviao--");
        try {
            String cod, nome, qtdA;
            
             do{
             cod = Console.scanString("Codigo: ");
             }while(StringUtils.isNullOrBlank(cod)==true||StringUtils.isNullOrEmpty(cod)==true);
             do{nome = Console.scanString("Nome: ");}while(StringUtils.isNullOrBlank(nome)==true||StringUtils.isNullOrEmpty(nome)==true);
             do {                
                             qtdA = Console.scanString("Quantidade de lugares: ");
            } while (StringUtils.isNullOrBlank(qtdA)==true||StringUtils.isNullOrEmpty(qtdA)==true);
            int qtd = Integer.parseInt(qtdA);
            if(Repositorio.RepositorioAviao.getInstance().buscarAviao(cod)==null){
            Aviao aviao = new Aviao(cod, nome, qtd);
            Repositorio.RepositorioAviao.getInstance().add(aviao);
            System.out.println("Cadastro de avião realizado com sucesso ! ");
            }else{
            System.out.println("ERRO: AVIAO EXISTENTE.. tente novamente!");
            adicionarAviao();
            }    
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Erro: informe dados corretos!");
        }
        

    }  
    
    private static void cadastrarVoo() {
        System.out.println("... adicionando cadastro de voo");
        System.out.println("Selecione Avião: ");
        
        listarAvioes();
        LocalTime horario;
        String cod,destino,origem,dataHora,codV;
        try {
            
            do {                
                             cod = Console.scanString("CODIGO VOO: ");
            } while (StringUtils.isNullOrBlank(cod)==true||StringUtils.isNullOrEmpty(cod)==true);
            do {                
                             destino = Console.scanString("DESTINO: ");
            } while (StringUtils.isNullOrBlank(destino)==true||StringUtils.isNullOrEmpty(destino)==true);
            do {                
                             origem = Console.scanString("ORIGEM: ");
            } while (StringUtils.isNullOrEmpty(origem)==true||StringUtils.isNullOrBlank(origem)==true);
            do {                
                             dataHora = Console.scanString("HORARIO: FORMAT (hh:mm):");
            } while (StringUtils.isNullOrBlank(dataHora)==true||StringUtils.isNullOrEmpty(dataHora)==true);
            do {                
                             codV = Console.scanString("CODIGO DE VOO:  ");
            } while (StringUtils.isNullOrBlank(codV)==true||StringUtils.isNullOrEmpty(codV)==true);
            
            horario = LocalTime.parse(dataHora);
            Voo Voo = new Voo(codV,Repositorio.RepositorioAviao.getInstance().buscarAviao(cod), destino, origem, horario );
            Repositorio.RepositorioVoo.getInstance().add(Voo);
        } catch (DateTimeParseException ex) {
            System.out.println("Data ou hora no formato inválido!");  
        }
        System.out.println("Cadastro de Vôo realizado com sucesso! ");
 
    }
    
    private static void listarClientes() {
        System.out.println("\nListando Pacientes...");
        if (RepositorioCliente.getInstance().estaVazio()) {
            System.out.println("Nao ha pacientes cadastrados!");
        }
        else{
            System.out.print(String.format("%-10s","|RG"));
            System.out.print(String.format("%-20s","|NOME"));
            System.out.println(String.format("%-10s","|TELEFONE"));
            for(Cliente p: RepositorioCliente.getInstance().getClientes()){
                System.out.print(String.format("%-10s",p.getRG()));
                System.out.print(String.format("%-20s",p.getNome()));
                System.out.println(String.format("%-10s",p.getTelefone()));

            }
        }        
    }
    
    private static void listarAvioes(){
        
        System.out.print(String.format("%-10s","|CODIGO"));
        System.out.print(String.format("%-20s","|NOME"));
        System.out.println(String.format("%-10s","|QUANTIDADE DE ASSENTOS"));
        for(Aviao v: Repositorio.RepositorioAviao.getInstance().getAviao()){
            System.out.print(String.format("%-10s",v.getCódigo()));
            System.out.print(String.format("%-20s",v.getNome()));
            System.out.println(String.format("%-10s",v.getQtdAssentos()));
       
        }  
   
    }
 
    private static void ListarCadastrovoo(){
        System.out.print(String.format("%-10s","|AVIAO"));
        System.out.print(String.format("%-20s","|HORARIO"));
        System.out.println(String.format("%-10s","|ORIGEM"));
        System.out.println(String.format("%-10s","|DESTINO"));
    
        for(Voo c: Repositorio.RepositorioVoo.getInstance().getVoo()){
            System.out.println(String.format("%-10s", c.getAviao()));
            System.out.print(String.format("%-20s",c.getHorarioVoo()));        
            System.out.println(String.format("%-10s",c.getOrigem()));
            System.out.println(String.format("%-10s",c.getDestino()));
            
            
        }
    
    
    }

    private static void Venda(){
        try {
            String rg, codVenda, codVoo;
            
            
            do{  
            System.out.println("\n Criando Venda ....");  
            System.out.println("SELECIONE O CLIENTE: ");
            listarClientes();
             rg = Console.scanString("RG: ");
            }while(StringUtils.isNullOrBlank(rg)==true||StringUtils.isNullOrEmpty(rg)==true);
            Cliente cliente = RepositorioCliente.getInstance().buscarCliente(rg);
            
            do{
            System.out.println("SELECIONE O VOO");
            ListarCadastrovoo();
            codVoo = Console.scanString("Codigo do Vôo");
            }while(StringUtils.isNullOrBlank(codVoo)==true||StringUtils.isNullOrEmpty(codVoo)==true);
            
            Voo cad = Repositorio.RepositorioVoo.getInstance().buscarVoo(codVoo);

            do
            codVenda = Console.scanString("Insira um codigo para venda: ");
            while(StringUtils.isNullOrBlank(codVenda)==true||StringUtils.isNullOrEmpty(codVenda)==true);
            Venda venda = new Venda();
            venda.registraVenda(cliente, cad, codVenda);
            Repositorio.RepositorioVenda.getInstance().add(venda);
            
        } catch (InputMismatchException e) {
            System.err.println("");
        }
            System.out.println("Venda realizada com sucesso !!");
    }
    
    private static void  Relatorio(){
        int  stop,op = 0;
        String dado ;
        do{
            try{
            System.out.println("Selecione uma opção: ");
            System.out.println("1 - Consulta Geral: ");
            System.out.println("2 - Consulta por Aviao: ");
            System.out.println("3 - Consulta por Data: ");
            System.out.println("4 - Consulta por Cliente");
            System.out.println("0 - Voltar: ");
            op =  Console.scanInt("Opção : ");
            switch(op){
            
                case 1:
                    RelatorioGeral();
                    break;
                case 2:
                     stop=0;
                    do{
                        stop++;
                        dado = Console.scanString("Informe o codigo do Aviao: ");
                    }while(StringUtils.isNullOrBlank(dado)!=true||StringUtils.isNullOrEmpty(dado)!=true||stop==3);
                        
                        if(StringUtils.isNullOrBlank(dado)!=true||StringUtils.isNullOrEmpty(dado)!=true){
                            buscarPorAviao(dado);
                        }else{
                            System.err.println("Informação invalida -- em branco ou nulo!!!");
                        }
                    break;
                case 3:
                    stop=0;
                    do{
                        stop++;
                        dado = Console.scanString("Informe o RG: ");
                    }while(StringUtils.isNullOrBlank(dado)!=true||StringUtils.isNullOrEmpty(dado)!=true||stop==3);
                        
                        if(StringUtils.isNullOrBlank(dado)!=true||StringUtils.isNullOrEmpty(dado)!=true){
                            buscarPorData(dado);
                        }else{
                            System.err.println("Informação invalida -- em branco ou nulo!!!");
                        }
                    break;
                case 4:
                     stop=0;
                    do{
                        stop++;
                        dado = Console.scanString("Informe a data: ");
                    }while(StringUtils.isNullOrBlank(dado)!=true||StringUtils.isNullOrEmpty(dado)!=true||stop==3);
                        
                        if(StringUtils.isNullOrBlank(dado)!=true||StringUtils.isNullOrEmpty(dado)!=true){
                            BuscaPorCliente(dado);
                        }else{
                            System.err.println("Informação invalida -- em branco ou nulo!!!");
                        }
                    break;
                case 0:
                    System.out.println("Saindo do Sistema...");
                    break;
                default:
                    System.err.println("Erro: Escolha a opcao correta!!");
            }          
            }catch(InputMismatchException e){
                        System.err.println("Erro: Escolha a opcao correta!!");
            }                 
        }while (op!=0);
    
    }
    
    private static void  RelatorioGeral(){
    
        System.out.println("Relatorio de vendas");
        
        System.out.print(String.format("%-10s","|CODIGO"));
        System.out.println(String.format("%-10s","|VOO"));
        System.out.println(String.format("%-20s","|DATA: "));
        System.out.println(String.format("%-10s","|QUANTIDADE DE ASSENTOS"));
        
        for(Venda v: Repositorio.RepositorioVenda.getInstance().getVenda()){
            
            System.out.print(String.format("%-10s",v.getCodVenda()));
            System.out.print(String.format("%-20s",v.getCliente()));
            System.out.println(String.format("%-10s",v.getVoo()));
            System.out.println(String.format("%-20s",v.getDataCompra()));
            System.out.println(String.format("%-10s",v.getVoo()));


        }  
    }
    
     private static void buscarPorAviao(String cod){
                int cont = 0, qtdAssento = 0;

            System.out.print(String.format("%-10s","|CODIGO"));
            System.out.println(String.format("%-20s","|COD COMPRA"));
            System.out.println(String.format("%-10s","|QUANTIDADE DE ASSENTOS"));
            System.out.println(String.format("%-20s","|VOO"));
            System.out.println(String.format("%-10s","|DATA: "));
            for(Venda v: RepositorioVenda.getInstance().getVenda()){
                if(RepositorioVenda.getInstance().buscarPorAviao(cod).equals(v)){
                    cont++;
                    qtdAssento = v.getVoo().getAviao().getQtdAssentos();
                    System.out.print(String.format("%-10s",v.getCodVenda()));
                    System.out.print(String.format("%-20s",v.getCliente()));
                    System.out.println(String.format("%-10s",v.getVoo()));
                    System.out.println(String.format("%-20s",v.getDataCompra()));
           }
       }
        
        }

     private static void buscarPorData(String cod){
        int cont = 0, qtdAssento = 0;

        System.out.print(String.format("%-10s","|CODIGO"));
        System.out.println(String.format("%-20s","|COD COMPRA"));
        System.out.println(String.format("%-10s","|QUANTIDADE DE ASSENTOS"));
        System.out.println(String.format("%-20s","|VOO"));
        System.out.println(String.format("%-10s","|DATA: "));
        for(Venda v: RepositorioVenda.getInstance().getVenda()){
           if(RepositorioVenda.getInstance().buscarPorData(cod).equals(v)){
               cont++;
                qtdAssento = v.getVoo().getAviao().getQtdAssentos();
            System.out.print(String.format("%-10s",v.getCodVenda()));
            System.out.print(String.format("%-20s",v.getCliente()));
            System.out.println(String.format("%-10s",v.getVoo()));
            System.out.println(String.format("%-20s",v.getDataCompra()));
           }
       }
        System.out.println("Quantidade de Assentos: " + qtdAssento );
        qtdAssento = cont  - qtdAssento;
        System.out.println("Assentos Disponiveis : "+ qtdAssento);
    }
    
    private static void BuscaPorCliente(String cod) {
        int cont = 0, qtdAssento = 0;
        /**
         *  Busca venda por Cliente
         */
        //Busca pelo Codigo de venda: 
        System.out.print(String.format("%-10s","|CODIGO"));
        System.out.println(String.format("%-20s","|COD COMPRA"));
        System.out.println(String.format("%-10s","|QUANTIDADE DE ASSENTOS"));
        System.out.println(String.format("%-20s","|VOO"));
        System.out.println(String.format("%-10s","|DATA: "));
        // Busca pelo RG do cliente
       for(Venda v: RepositorioVenda.getInstance().getVenda()){
           if(RepositorioVenda.getInstance().buscarPorCliente(cod).equals(v)){
            cont++;
            qtdAssento = v.getVoo().getAviao().getQtdAssentos();
            System.out.print(String.format("%-10s",v.getCodVenda()));
            System.out.print(String.format("%-20s",v.getCliente()));
            System.out.println(String.format("%-10s",v.getVoo()));
            System.out.println(String.format("%-20s",v.getDataCompra()));
           }
       }
        System.out.println("Quantidade de Assentos: " + qtdAssento );
        qtdAssento = cont  - qtdAssento;
        System.out.println("Assentos Disponiveis : "+ qtdAssento);

    }
}//fim classe


            
          