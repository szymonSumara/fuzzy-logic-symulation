import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Driver{
    private FuzzyRuleSet fuzzyRuleSet;

    Driver(){
        FIS fis = FIS.load("driver.FCL",false);
        fuzzyRuleSet = fis.getFuzzyRuleSet();
    }

    public void setSpeed(double speed){
        fuzzyRuleSet.setVariable("speed", speed);
    }

    public void setAngle(double angle){
        fuzzyRuleSet.setVariable("angle", angle);
    }

    public void setDistance(double distance){
        fuzzyRuleSet.setVariable("distance", distance);
    }

    public void evaluate(){
        fuzzyRuleSet.evaluate();
    }

    public double getAcceleration(){
        return fuzzyRuleSet.getVariable("acceleration").getLatestDefuzzifiedValue();
    }

    public double getWellRotation(){
        return  fuzzyRuleSet.getVariable("turn").getLatestDefuzzifiedValue();
    }
}

