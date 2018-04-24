/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author jonh_
 */
public class Cliente {
    
    private String RG, nome, telefone;

    public Cliente(String RG, String nome, String telefone) {
        this.RG = RG;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.RG, other.RG)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.RG);
        return hash;
    }
    
    
    @Override
    public String toString() {
        return "Cliente{" + "RG=" + RG + ", nome=" + nome + ", telefone=" + telefone + '}';
    }
    
    
    
}
