import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Verifier {

    static ArrayList<String> linesOfCode = new ArrayList<>();
    static ArrayList<Rule> rulesToEnforce = new ArrayList<>();

    public static void main(String[] args) {
        //TODO: Let the user select which file to check for enforcable rules
        linesOfCode = readFile("");
        rulesToEnforce = selectRules();
        enforce();
    }

    public static ArrayList<String> readFile(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null)
                linesOfCode.add(line);
            br.close();
        } catch (IOException ioe) {
            handleException(ioe);
        }

        return linesOfCode;
    }

    public static ArrayList<Rule> selectRules() {
        //TODO: Create rules and append them to List
        //TODO: Add user input via console to change which rules to check

        return null;
    }

    public static void enforce() {
        for (Rule rule : rulesToEnforce) {
            try {
                if (rule.shouldBeEnforced()) rule.enforceRule(linesOfCode);
            } catch(IllegalMethodCall imc) {
                handleException(imc);
            }
        }
    }
    
    private static void handleException(Exception e) {
        System.err.println(e.getMessage());
        System.err.println(e.getStackTrace());
    }
}
