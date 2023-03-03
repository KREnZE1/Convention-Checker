
public class SpaceBetweenPlus extends Rule {

    static final String description = "Before and after a '+' should always be spaces to make the code more legible";


    public SpaceBetweenPlus() {
        super(description, RuleStates.NONFUNCTIONAL);
    }

    public String applyRule(String s) {
        boolean doubleSignFlag = false;
        for (int i=0; i<s.length()-1; i++) {
            if (!doubleSignFlag && s.charAt(i) == '+' && s.charAt(i+1) != '+') { //Ignores the ++ operator
                s = insertMissingSpaces(s, i);
                doubleSignFlag = true;
            } else if (s.charAt(i) == '+' && s.charAt(i+1) == '+') doubleSignFlag = true;
            else doubleSignFlag = false;
        }

        if (s.charAt(s.length()-1) == '+' && !doubleSignFlag) s = insertMissingSpaces(s, s.length()-1);

        return s;
        //TODO: Don't add a space in the front or the back when it isn't necessary
        //e.g. when there are no more characters before or after the space
    }

    public String insertMissingSpaces(String s, int i) {
        int beforeIndex = i-1;
        int afterIndex = i+1;

        if (beforeIndex > 0 && s.charAt(beforeIndex) != ' ') { //Inserts a whitespace before the plus
            String before = s.substring(0, i);
            String after = " " + s.substring(i);
            s = before + after;
            afterIndex++;
        }

        if (afterIndex < s.length()-1 && s.charAt(afterIndex) != ' ') { //Inserts a whitespace after the plus
            String before = s.substring(0, afterIndex);
            String after = " " + s.substring(afterIndex);
            s = before + after;
        }

        return s;
    }

}

//TODO: Possibly generalise rule to accept all arithmetic and comparison operators (+; -; *; /; <; >)
//TODO: Disregard rule if + is encased in quotes (singular and double)