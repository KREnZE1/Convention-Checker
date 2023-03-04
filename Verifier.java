import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Verifier {

    static ArrayList<String> linesOfCode = new ArrayList<>();
    static ArrayList<Rule> rulesToEnforce = new ArrayList<>();

    public static void main(String[] args) {
        //TODO: Let the user select which file to check for enforcable rules
        String path = "JavaTestFile.java";
        linesOfCode = readFile(path, linesOfCode);
        rulesToEnforce = selectRules();
        linesOfCode = enforce();
        writeFile(getNewPath(path), linesOfCode);
    }

    public static ArrayList<String> readFile(String path, ArrayList<String> storage) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null)
                storage.add(line);
            br.close();
        } catch (IOException ioe) {
            handleException(ioe);
        }

        return storage;
    }

    public static void writeFile(String path, ArrayList<String> lines) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for (String s : lines) bw.write(s + "\n");
            bw.close();
        } catch(IOException ioe) {handleException(ioe);}
    }

    public static String getNewPath(String oldPath) {
        int index = oldPath.lastIndexOf(".");
        String before = oldPath.substring(0, index);
        String after = "2" + oldPath.substring(index);
        return before + after;
    }

    public static ArrayList<Rule> selectRules() {
        //TODO: Create rules and append them to List
        //TODO: Add user input via console to change which rules to check
        ArrayList<Rule> ruleset = new ArrayList<>();
        ruleset.add(new SpaceBetweenPlus());
        return ruleset;
    }

    public static ArrayList<String> enforce() {
        for (Rule rule : rulesToEnforce) {
            try {
                if (rule.shouldBeEnforced()) rule.enforceRule(linesOfCode);
            } catch(IllegalMethodCall imc) {
                handleException(imc);
            }
        }
        return linesOfCode;
    }

    private static void handleException(Exception e) {
        System.err.println(e.getMessage());
        System.err.println(e.getStackTrace());
    }
}
