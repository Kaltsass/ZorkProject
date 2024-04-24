import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        welcoming.main(args);
        System.out.println("\n");

        // Call helpXml to display available commands
       // helpXml.main(args);

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Giatzo\\IdeaProjects\\ZorkProject\\src\\LoadingGame.txt"));
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("C:\\Users\\Giatzo\\IdeaProjects\\ZorkProject\\src\\commands.xml"));

        Scanner keyboardInput = new Scanner(System.in);
        String userInput;
        do {
            System.out.println("Enter a command:");
            userInput = keyboardInput.nextLine();
            if (userInput.equals("help") || userInput.equals("/help")) {
                try {
                    helpXmlReader.main(args);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
                // Check for valid command
                if (isValidCommand(doc, userInput)) {
                    writer.write(userInput);
                    writer.newLine();
                } else if (!userInput.equalsIgnoreCase("exit")) {
                    System.out.println("Invalid command. Type 'help' for available commands.");
                }

            }
            while (!userInput.equalsIgnoreCase("exit")) ;

            writer.close();
        }
        private static boolean isValidCommand (Document doc, String command){
            NodeList nodeList = doc.getElementsByTagName("*");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    NodeList childNodes = element.getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node childNode = childNodes.item(j);
                        if (childNode.getNodeType() == Node.TEXT_NODE) {
                            String text = childNode.getTextContent();
                            if (text.contains(command)) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

