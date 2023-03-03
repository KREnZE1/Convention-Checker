import java.util.ArrayList;

public abstract class Rule {

    static String description;
    static RuleStates state;

    public static boolean shouldBeEnforced() {
        return state == RuleStates.ACTIVE;
    }

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
        throw new IllegalMethodCall("This method should never be called on the parent class");
    }
}
