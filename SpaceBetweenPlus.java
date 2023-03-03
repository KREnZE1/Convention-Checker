
public class SpaceBetweenPlus extends Rule {

    static final String description = "Before and after a '+' should always be spaces to make the code more legible";
    static final RuleStates state = RuleStates.NONFUNCTIONAL;

    public static String insertMissingSpace(String s, int i) {
        if (i == s.length()) return s + " ";

        if (s.charAt(i) != ' ') {
            String before = s.substring(0, i);
            String after = " " + s.substring(i);
            return before+after;
        }

        return s;
    }

    public static String applyRule(String s) {
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '+') {
                s = insertMissingSpace(s, i+1);
                s = insertMissingSpace(s, i);
            }
        }
        return s;
    }

}
