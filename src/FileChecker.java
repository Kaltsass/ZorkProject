
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//Method that checks if the file LoadingGame.txt full of the available commands is empty or not in order to load or create a new game
public class FileChecker {

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\lange\\IdeaProjects\\tests\\Zorkv_1\\src\\LoadingGame.txt");

        if (file.exists() && !file.isDirectory()) {
            if (file.length() == 0) {
                welcoming.main(args);
            } else {
                // Αν το αρχείο έχει περιεχόμενο, εμφάνισέ το
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                System.out.println("Περιεχόμενο του αρχείου LoadingGame.txt:");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            }
        }
    }
}