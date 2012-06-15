/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coloniaformiga;

/**
 *
 * @author lailson
 */
public class Requisito {
       private static final int NUM_REQUISITOS = 12;
       private String nome; //Nome do item
       private float relevancia; //Relevancia eh um valor de 0 a 10
       private int tamanho; //Homens hora
       private double feromonio=1.0; //Quantidade de feromonio
       private float desejabilidade;
       
       public Requisito(String nome, float relevancia, int tamanho ) {
        this.nome = nome;
        this.relevancia = relevancia;
        this.tamanho = tamanho;  
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getRelevancia() {
        return relevancia;
    }

    public void setRelevancia(float relevancia) {
        this.relevancia = relevancia;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public double getFeromonio() {
        return feromonio;
    }

    public void setFeromonio(double feromonio) {
        this.feromonio = feromonio;
    }

    public float getDesejabilidade() {
        return desejabilidade;
    }

    public void setDesejabilidade(float desejabilidade) {
        this.desejabilidade = desejabilidade;
    }
    
    
    
}
