
public class SpaceBetweenPlus extends Rule {

    static final String description = "Before and after a '+' should always be spaces to make the code more legible";

    public SpaceBetweenPlus() {
        super(description, RuleStates.NONFUNCTIONAL);
    }

    public boolean canBeApplied(String s) {
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '+') return true;
        }
        return false;
    }

    public boolean notYetApplied(String s) {
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '+' && missingSpace(s, i)) return true;
        }
        return false;
    }

    public boolean missingSpace(String s, int i) {
        boolean before = (i>0 && (s.charAt(i-1) != ' ')); //Checks the character in front of the given index
        boolean after = (i<s.length()-1 && (s.charAt(i+1) != ' ')); //Checks the character afte rthe given index
        return (before || after); //Returns whether at least one of the checked chars was not a whitespace
    }

    public String checkForSpaceAndInsertIfMissing(String s, int i) {
        //TODO: Find purpose for this method
        if (i == s.length()) return s + " ";

        if (s.charAt(i) != ' ') {
            String before = s.substring(0, i);
            String after = " " + s.substring(i);
            return before+after;
        }

        return s;
    }

    public String applyRule(String s) {
        //TODO: Implement
        return "";
    }
}
