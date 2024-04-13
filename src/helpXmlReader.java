import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.File;
public class helpXmlReader {

    public static void  main(String [] args)throws Exception{

        File commands = new File("C:\\Users\\lange\\IdeaProjects\\tests\\Zorkv_1\\src\\commands.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(commands);

        NodeList nodeList = document.getElementsByTagName("commands");
        for (int i =0; i<nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            System.out.println("The commands are the following and only the following: " + node.getTextContent());
            System.out.println("Any other command will not work or will throw an error \n");
            System.out.println("Thank you for playing our game! \n");
        }

    }


}
