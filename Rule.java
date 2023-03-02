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
        for (String s : linesOfCode) {
            //TODO: Rethink structure of basically checking the string twice before manipulating it
            //Might lead to performance issues due to possibly looping the same string three times
            if (canBeApplied(s) && notYetApplied(s)) {
                applyRule(s);
            }
        }
    }

    public abstract boolean canBeApplied(String s);
    public abstract boolean notYetApplied(String s);
    public abstract String applyRule(String s);
}
