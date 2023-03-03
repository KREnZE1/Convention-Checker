import java.util.ArrayList;

public abstract class Rule {

    String description;
    RuleStates state;

    public Rule(String pDescription, RuleStates pState) {
        this.description = pDescription;
        this.state = pState;
    }

    public String getDescription() {return this.description;}
    public RuleStates getState() {return this.state;}

    public boolean shouldBeEnforced() {
        return (this.state == RuleStates.ACTIVE);
    }

    public void enforceRule(ArrayList<String> linesOfCode) {
        for (int i=0; i<linesOfCode.size(); i++) {
            String temp = applyRule(linesOfCode.get(i));
            linesOfCode.add(i, temp);
            linesOfCode.remove(i+1);
        }
    }


    public abstract String applyRule(String s);
}
