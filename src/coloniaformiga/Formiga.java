/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coloniaformiga;

import java.util.ArrayList;

/**
 *
 * @author lailson
 */
public class Formiga {

    ArrayList<Requisito> mochila = new ArrayList<Requisito>();
    private int passos = 0;

    public Formiga() {
    
    }

    public int getPassos() {
        return passos;
    }

    public void setPassos(int passos) {
        this.passos = passos;
    }

    public int pesoMochila(){
        int i=0,soma=0;
        for(i=0;i<mochila.size();i++){
            soma=soma+ mochila.get(i).getTamanho();
        }
        return soma;
    }
    

    
    
    
    
    
}
