package jfuzzylogic;



import net.sourceforge.jFuzzyLogic.FIS;
import org.jfree.chart.JFreeChart;
//import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

/**
 * Test parsing an FCL file
 * @author pcingola@users.sourceforge.net
 */
public class JFuzzy {
    public static void main(String[] args) throws Exception {
        // Load from 'FCL' file
        String fileName = "src/jfuzzylogic/relevancia.fcl";
        FIS fis = FIS.load(fileName,true);
        // Error while loading?
        if( fis == null ) { 
            System.err.println("Can't load file: '" 
                                   + fileName + "'");
            return;
        }
        //Interface gui = new Interface();
        //gui.show();
        
        // Mostra gráficos 
        fis.chart();

        //Requisito: Notificate by email
        // Dados de entrada
        fis.setVariable("importancia", 2);
        fis.setVariable("risco", 5);
        // Calcular
        fis.evaluate();
        // Mostrar gráfico das variaveis de saida
        fis.getVariable("relevancia").chartDefuzzifier(true);
        System.out.println("Requisito 1:Notificate by email = "+fis.getVariable("relevancia").getValue());
        
        //Requisito: Change password
        fis.setVariable("importancia", 3);
        fis.setVariable("risco", 3);
        fis.evaluate();
        //fis.getVariable("relevancia").chartDefuzzifier(true);
        System.out.println("Requisito 2:Change password = "+fis.getVariable("relevancia").getValue());
        
        //Requisito: Register User
        fis.setVariable("importancia", 5);
        fis.setVariable("risco", 3);
        fis.evaluate();
        //fis.getVariable("relevancia").chartDefuzzifier(true);
        System.out.println("Requisito 3: Register User = "+fis.getVariable("relevancia").getValue());
        
        //Requisito: Label tipping report
        fis.setVariable("importancia", 2);
        fis.setVariable("risco", 1);
        fis.evaluate();
        //fis.getVariable("relevancia").chartDefuzzifier(true);
        System.out.println("Requisito 4: Label tipping report = "+fis.getVariable("relevancia").getValue());
        
        //Requisito: cancel borrowing request
        fis.setVariable("importancia", 3);
        fis.setVariable("risco", 2);
        fis.evaluate();
        //fis.getVariable("relevancia").chartDefuzzifier(true);
        System.out.println("Requisito 5: borrowing request = "+fis.getVariable("relevancia").getValue());
        
        //Requisito: Register book
        fis.setVariable("importancia", 4);
        fis.setVariable("risco", 2);
        fis.evaluate();
        fis.getVariable("relevancia").chartDefuzzifier(true);
        System.out.println("Requisito 6: Register book = "+fis.getVariable("relevancia").getValue());
        
        //Requisito: cancel borrowing request
        fis.setVariable("importancia", 3);
        fis.setVariable("risco", 3);
        fis.evaluate();
        //fis.getVariable("relevancia").chartDefuzzifier(true);
        System.out.println("Requisito 7: cancel borrowing request = "+fis.getVariable("relevancia").getValue());
        
        //Requisito: Register publication
        fis.setVariable("importancia", 5);
        fis.setVariable("risco", 3);
        fis.evaluate();
        //fis.getVariable("relevancia").chartDefuzzifier(true);
        System.out.println("Requisito 8: Register publication = "+fis.getVariable("relevancia").getValue());
        
        //Requisito: Confirm borrowing
        fis.setVariable("importancia", 3);
        fis.setVariable("risco", 2);
        fis.evaluate();
        //fis.getVariable("relevancia").chartDefuzzifier(true);
        System.out.println("Requisito 9: Confirm borrowing = "+fis.getVariable("relevancia").getValue());
        
        //Requisito: Finish borrowing
        fis.setVariable("importancia", 3);
        fis.setVariable("risco", 4);
        fis.evaluate();
        //fis.getVariable("relevancia").chartDefuzzifier(true);
        System.out.println("Requisito 10: Finish borrowing = "+fis.getVariable("relevancia").getValue());
        
        //Requisito: Log in
        fis.setVariable("importancia", 5);
        fis.setVariable("risco", 2);
        fis.evaluate();
        //fis.getVariable("relevancia").chartDefuzzifier(true);
        System.out.println("Requisito 11: Log in = "+fis.getVariable("relevancia").getValue());
        
        //Requisito: Request borrowing
        fis.setVariable("importancia", 5);
        fis.setVariable("risco", 3);
        fis.evaluate();
        //fis.getVariable("relevancia").chartDefuzzifier(true);
        System.out.println("Requisito 12: Request borrowing = "+fis.getVariable("relevancia").getValue());
        
        //Requisito: Borrowing report
        fis.setVariable("importancia", 2);
        fis.setVariable("risco", 1);
        fis.evaluate();
        //fis.getVariable("relevancia").chartDefuzzifier(true);
        System.out.println("Requisito 13: Borrowing report = "+fis.getVariable("relevancia").getValue());
        
        

        // Print ruleSet
        //System.out.println(fis);
    }
}