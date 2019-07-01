import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile("hamlet.txt");
    }

    public String loadFile(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public String changeHamlet(String replacement){


        Pattern p = Pattern.compile("Hamlet");
        Matcher m = p.matcher(this.hamletData);
        String intermediate = m.replaceAll(replacement);

        p = Pattern.compile("HAMLET");
        m = p.matcher(intermediate);
        return m.replaceAll(replacement.toUpperCase());
    }

    public String changeHoratio(String replacement){


        Pattern p = Pattern.compile("Horatio");
        Matcher m = p.matcher(this.hamletData);
        String intermediate = m.replaceAll(replacement);

        p = Pattern.compile("HORATIO");
        m = p.matcher(intermediate);
        return m.replaceAll(replacement.toUpperCase());
    }

}
