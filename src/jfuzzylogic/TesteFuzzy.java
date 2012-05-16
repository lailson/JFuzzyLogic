package jfuzzylogic;



import net.sourceforge.jFuzzyLogic.FIS;
//import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

/**
 * Test parsing an FCL file
 * @author pcingola@users.sourceforge.net
 */
public class TesteFuzzy {
    public static void main(String[] args) throws Exception {
        // Load from 'FCL' file
        String fileName = "/Users/lailson/NetBeansProjects/JFuzzyLogic/src/jfuzzylogic/relevancia.fcl";
        FIS fis = FIS.load(fileName,true);
        // Error while loading?
        if( fis == null ) { 
            System.err.println("Can't load file: '" 
                                   + fileName + "'");
            return;
        }

        // Show 
        fis.chart();

        // Set inputs
        fis.setVariable("importancia", 2);
        fis.setVariable("risco", 2);

        // Evaluate
        fis.evaluate();

        // Show output variable's chart 
        fis.getVariable("relevancia").chartDefuzzifier(true);

        // Print ruleSet
        System.out.println(fis);
    }
}