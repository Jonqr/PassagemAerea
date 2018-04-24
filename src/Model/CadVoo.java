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
public class CadVoo implements Comparable<CadVoo>{
        
        private Aviao aviao;
        private String destino, origem;
        private LocalTime horarioVoo;
        private int qtdAssento;
        
   
    public CadVoo( Aviao aviao, String destino, String origem,LocalTime HORA) {
        
       
        this.horarioVoo = HORA;
        this.aviao = aviao;
        this.destino = destino;
        this.origem = origem;
        
    }


    public int getQtdAssento() {
        qtdAssento = this.aviao.getQtdAssentos();
        return qtdAssento;
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
    public int compareTo(CadVoo o) {
        return(this.getHorarioVoo().compareTo(o.getHorarioVoo()));
    }
    
    
}
