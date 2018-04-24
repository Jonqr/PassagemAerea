/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jonh_
 */
public class Aviao {
    
    private String codigo, nome;
    private int qtdAssentos;

    public Aviao(String código, String nome, int qtdAssentos) {
        this.codigo = código;
        this.nome = nome;
        this.qtdAssentos = qtdAssentos;
    }

    public String getCódigo() {
        return codigo;
    }

    public void setCódigo(String código) {
        this.codigo = código;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdAssentos() {
        return qtdAssentos;
    }

    public void setQtdAssentos(int qtdAssentos) {
        this.qtdAssentos = qtdAssentos;
    }

    @Override
    public String toString() {
        return "Aviao{" + "c\u00f3digo=" + codigo + ", nome=" + nome + ", qtdAssentos=" + qtdAssentos + '}';
    }
    
    
}
