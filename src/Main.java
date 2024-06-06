
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        welcoming.main(args);
        System.out.println("\n");

        MovementCreation.displayCurrentRoom();

        String saveFilePath = "C:\\Users\\Giatzo\\IdeaProjects\\ZorkProject\\src\\LoadingGame.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(saveFilePath, true));

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("C:\\Users\\Giatzo\\IdeaProjects\\ZorkProject\\src\\commands.xml"));

        Scanner keyboardInput = new Scanner(System.in);
        String userInput;

        Hashtable<String, String> inventory = new Hashtable<>();

        // Επιλογή New Game ή Load Game
        System.out.println("Welcome! Would you like to start a new game or load a saved game?");
        System.out.println("Enter 'new' for a New Game or 'load' for Load Game:");

        String gameChoice = keyboardInput.nextLine().trim().toLowerCase();
        while (!gameChoice.equals("new") && !gameChoice.equals("load")) {
            System.out.println("Invalid choice. Please enter 'new' for a New Game or 'load' for Load Game:");
            gameChoice = keyboardInput.nextLine().trim().toLowerCase();
        }

        if (gameChoice.equals("load")) {
            // Φόρτωση προηγούμενων εντολών
            loadPreviousCommands(saveFilePath, inventory, doc);
        } else {
            // Αν είναι New Game, καθαρίζουμε το αρχείο save
            new FileWriter(saveFilePath, false).close();
        }

        do {
            System.out.println("Enter a command:");
            userInput = keyboardInput.nextLine().trim().toLowerCase();
            if (userInput.equals("help") || userInput.equals("/help")) {
                try {
                    helpXmlReader.main(args);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            if (isValidCommand(doc, userInput, inventory)) {
                writer.write(userInput);
                writer.newLine();

                MovementCreation.handleCommand(userInput, inventory);
                if (userInput.equalsIgnoreCase("move forward") ||
                        userInput.equalsIgnoreCase("move back") ||
                        userInput.equalsIgnoreCase("move left") ||
                        userInput.equalsIgnoreCase("move right")) {
                    MovementCreation.displayCurrentRoom();
                }
            } else if (!userInput.equalsIgnoreCase("exit")) {
                System.out.println("Invalid command. Type 'help' for available commands.");
            }

        } while (!userInput.equalsIgnoreCase("exit"));

        writer.close();
    }

    private static boolean isValidCommand(Document doc, String command, Hashtable<String, String> inventory) throws Exception {
        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                NodeList childNodes = element.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node childNode = childNodes.item(j);
                    if (childNode.getNodeType() == Node.TEXT_NODE) {
                        String text = childNode.getTextContent().toLowerCase();
                        if (text.contains(command)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static void loadPreviousCommands(String filePath, Hashtable<String, String> inventory, Document doc) throws Exception {
        File file = new File(filePath);
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (isValidCommand(doc, line, inventory)) {
                    MovementCreation.handleCommand(line, inventory);
                }
            }
            reader.close();
        }
    }
}
