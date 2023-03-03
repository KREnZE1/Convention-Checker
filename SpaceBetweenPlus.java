
public class SpaceBetweenPlus extends Rule {

    static final String description = "Before and after a '+' should always be spaces to make the code more legible";

    //TODO: Add exception for ++ operator

    public SpaceBetweenPlus() {
        super(description, RuleStates.NONFUNCTIONAL);
    }

    public String insertMissingSpace(String s, int i) {
        if (i == s.length()) return s + " ";

        if (s.charAt(i) != ' ') {
            String before = s.substring(0, i+1);
            String after = " " + s.substring(i+1);
            return before+after;
            //TODO: Durchrechnen, welche Positionen zum Slicen dienen sollten
        }

        return s;
    }

    public String applyRule(String s) {
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '+') {
                s = insertMissingSpace(s, i+1);
                s = insertMissingSpace(s, i-1);
            }
        }
        return s;
    }
}
