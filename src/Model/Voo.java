/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jonh_
 */
public class Voo implements Comparable<Voo>{
        private String codVoo;
        private Aviao aviao;
        private String destino, origem;
        private LocalTime horarioVoo;
        private int qtdAssento;
        
   
    public Voo(String codVoo, Aviao aviao, String destino, String origem,LocalTime HORA) {
        
        this.codVoo = codVoo;
        this.horarioVoo = HORA;
        this.aviao = aviao;
        this.destino = destino;
        this.origem = origem;
    }


    public int getQtdAssento() {
       return Repositorio.RepositorioAviao.getInstance().getQtdAssentos(aviao);
    }

    public String getCodVoo() {
        return codVoo;
    }
            
    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }
        
    public Aviao getAviao() {
        return aviao;
    }

    public String getDestino() {
        return destino;
    }

    public String getOrigem() {
        return origem;
    }

    public String getHorarioVoo() {
        return horarioVoo.format(DateTimeFormatter.ISO_TIME);
    }
    
   
    @Override
    public int compareTo(Voo o) {
        return(this.getHorarioVoo().compareTo(o.getHorarioVoo()));
    }

    @Override
    public String toString() {
        return "Voo{" + "codVoo=" + codVoo + ", aviao=" + aviao + ", destino=" + destino + ", origem=" + origem + ", horarioVoo=" + horarioVoo+ '}';
    }
    
    
    
    
}
