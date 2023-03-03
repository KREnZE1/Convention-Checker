import java.util.ArrayList;

public abstract class Rule {

    static String description;
    static RuleStates state;

    // public abstract boolean shouldBeEnforced();

    public static void enforceRule(ArrayList<String> linesOfCode) {
        for (int i=0; i<linesOfCode.size(); i++) {
            String s = linesOfCode.get(i);
            s = applyRule(s);
            linesOfCode.add(i, s);
            linesOfCode.remove(i+1);
        }
    }


    public static String applyRule(String s) {
        //TODO: Throw Exception
        
        return "";
    }
}
