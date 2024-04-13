import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class rndSelectionItems {
    private static List<Element> randomElements;
    private static Element defaultElement;
    public static void main(String[] args) throws Exception {
        try {
            File inputFile = new File("C:\\Users\\lange\\IdeaProjects\\tests\\Zorkv_1\\src\\items.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);

            NodeList nodeList = doc.getElementsByTagName("pickables");

            // Convert NodeList to a List for easier manipulation
            List<Element> elementsList = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                elementsList.add((Element) nodeList.item(i));
            }

            Element defaultElement = elementsList.get(0);
            elementsList.remove(defaultElement);

            // Randomly pick elements from the list
            int numElementsToPick = 3; // Modify as needed
            Random random = new Random();
            List<Element> randomElements = new ArrayList<>();
            while (!elementsList.isEmpty() && randomElements.size() < numElementsToPick) {
                int randomIndex = random.nextInt(elementsList.size());
                randomElements.add(elementsList.get(randomIndex));
                elementsList.remove(randomIndex); // Ensure no duplicates
            }
            randomElements.add(defaultElement);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Element> getRandomElements(){
        return randomElements;
    }
    public static Element getDefaultElement(){
        return defaultElement;
    }
}




