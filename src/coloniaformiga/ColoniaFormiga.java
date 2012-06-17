/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coloniaformiga;

/**
 *
 * @author lailson
 */
public class ColoniaFormiga {

    private static int NUM_REQUISITOS = 13;
    private static int NUM_FORMIGAS = 13;
    private static double TAM_MAX = 0.3;
    private static double ALFA = 0.5; //Nivel de importancia do feromonio
    private static double BETA = 0.5; //Nivel de importancia da desejabilidade
    private static double EVAPORACAO = 0.5;
    private static double Q = 0.5;

    public static void main(String[] args) {
        int i, j;
        
        int iteracoes = 30, w;
        for (w = 0; w < iteracoes; w++) {
        double[] probabilidade = new double[NUM_REQUISITOS];

        //Iniciar Requisitos
        Requisito[] item = new Requisito[NUM_REQUISITOS];
        //item[] = new Requisito("Nome",Relevancia, Tamanho)
        item[0] = new Requisito("Notificate by email", 2, 16);
        item[1] = new Requisito("Change password", 5, 10);
        item[2] = new Requisito("Register users", 7, 16);
        item[3] = new Requisito("Label tipping report", 6, 5);
        item[4] = new Requisito("cancel borrowing request", 8, 10);
        item[5] = new Requisito("register book", 10, 18);
        item[6] = new Requisito("cancel borrowing", 5, 10);
        item[7] = new Requisito("register publication", 7, 16);
        item[8] = new Requisito("confirm borrowing", 8, 10);
        item[9] = new Requisito("finish borrowing", 4, 7);
        item[10] = new Requisito("log in", 10, 7);
        item[11] = new Requisito("request borrowing ", 7, 10);
        item[12] = new Requisito("borrowing report", 6, 5);

        
        double tam_max = 0;
        //Iniciar formigas
        Formiga[] formiga = new Formiga[13];
        for (i = 0; i < NUM_FORMIGAS; i++) {
            formiga[i] = new Formiga();
            formiga[i].mochila.add(item[i]);//Iniciando um requisito em cada formiga
        }

        //Calcular a desejabilidade de cada requisito
        for (i = 0; i < NUM_REQUISITOS; i++) {
            item[i].setDesejabilidade(item[i].getRelevancia() / item[i].getTamanho());
            //System.out.println(i + " " + item[i].getDesejabilidade());
        }

        //Tamanho máximo da mochila
        for (i = 0; i < NUM_REQUISITOS; i++) {
            tam_max = tam_max + item[i].getTamanho();
        }
        tam_max = tam_max * TAM_MAX;

        
            System.out.println("\nIteracao : "+w );
            //Gerar Matriz de Probabilidade
            double somaFeromonio = 0;
            double somaDesejabilidade = 0;
            for (i = 0; i < NUM_REQUISITOS; i++) {
                somaFeromonio = somaFeromonio + item[i].getFeromonio();
                somaDesejabilidade = somaDesejabilidade + item[i].getDesejabilidade();
                //System.out.println("Desejabilidade: " + item[i].getDesejabilidade());
            }
            //System.out.println("Soma Feromonio: " + somaFeromonio + "\nSoma Desejabilidade: " + somaDesejabilidade);
            double soma = 0.0;
            for (i = 0; i < NUM_REQUISITOS; i++) {
                probabilidade[i] = Math.pow(item[i].getFeromonio(), ALFA) * Math.pow(item[i].getDesejabilidade(), BETA) / (Math.pow(somaFeromonio, ALFA) * Math.pow(somaDesejabilidade, BETA));
                probabilidade[i] = arredondar(probabilidade[i], 2);
                //System.out.println("Probabilidade["+i+"]: " + probabilidade[i]);
                soma  += probabilidade[i];
            }


            //Loop

            int solucao = 0, num = 0;
            double tam = 0;
            for (j = 0; j < NUM_REQUISITOS; j++) {
                int cont = 0;
                while (formiga[j].pesoMochila() < tam_max && cont < 20) {

                    //Roleta Viciada
                    double aux = 0;
                    //calculaSomaAvaliacoes();
                    double limite = Math.random() * 100.0;
                    for (i = 0; ((i < NUM_REQUISITOS) && (aux < limite)); ++i) {
                        aux += probabilidade[i] * 100;
                    }
                    i--;
                    //System.out.println("Peso da mochila: "+ formiga[j].pesoMochila() +"Tamanho do item: "+ item[i].getTamanho() +"Tamanho max: "+tam_max);
                    if (!formiga[j].mochila.contains(item[i]) && (formiga[j].pesoMochila() + item[i].getTamanho()) < tam_max) {
                        formiga[j].mochila.add(item[i]);

                    }
                    //System.out.println(formiga[j].mochila.size());



                    cont++;
                }

                //Escolher solucao melhor
                //System.out.println("Num: "+ num + " Tam: "+ tam);    
                if (formiga[j].pesoMochila() > tam || formiga[j].pesoMochila() == tam && formiga[j].mochila.size() > num) {
                    num = formiga[j].mochila.size();
                    tam = formiga[j].pesoMochila();
                    solucao = j;
                    //System.out.println();
                }


            }//Fim do FOR

            //Solucao
            System.out.println("solucao: " + solucao);
            System.out.println("Quant requisitos: " + num + " Tamanho da mochila: " + tam);
            for(i=0;i<formiga[solucao].mochila.size();i++){
            //System.out.println("nome: "+formiga[solucao].mochila.get(i).getNome()+ " Relevancia: "+formiga[solucao].mochila.get(i).getRelevancia() + " Tamanho: "+formiga[solucao].mochila.get(i).getTamanho() );
            
            }
            //Atualizar Feromonio
            for (i = 0; i < NUM_REQUISITOS; i++) {
                if (formiga[solucao].mochila.contains(item[i])) {
                    item[i].setFeromonio(item[i].getFeromonio() + Q - EVAPORACAO * item[i].getFeromonio());
                } else {
                    item[i].setFeromonio(item[i].getFeromonio() - EVAPORACAO * item[i].getFeromonio());
                }

            }
         
        for (i = 0; i < NUM_FORMIGAS; i++) {
            formiga[i].mochila.clear();
        }

        }//Fim da Iteracao

    }

    static double arredondar(double valor, int casas) {
        double verif, arredondado = valor;

        int multp = 1;
        for (int i = 0; i < casas; i++) {
            multp *= 10;
        }
        arredondado *= multp;
        verif = arredondado;
        arredondado = Math.ceil(arredondado);
        verif -= arredondado;
        verif = Math.ceil(verif * 10);

        if (verif > 4) {
            arredondado++;
        }
        arredondado /= multp;
        return arredondado;
    }
}