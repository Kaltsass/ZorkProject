import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
public class helpXml {
    //Creating the xml File that will later on display the available commands in our Game
    public static void main (String [] args)throws Exception{

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document commands = builder.newDocument();

        Element root = commands.createElement("commands");
        commands.appendChild(root);


        Element movement = commands.createElement("Move");
        movement.appendChild(commands.createTextNode("\nMove Forward \n"));
        movement.appendChild(commands.createTextNode("Move Left \n"));
        movement.appendChild(commands.createTextNode("Move Right \n"));
        movement.appendChild(commands.createTextNode("Move Back \n"));

        Element go = commands.createElement("Go");
        go.appendChild(commands.createTextNode("\nGo Upstairs \n"));
        go.appendChild(commands.createTextNode("Go Downstairs \n"));

        Element open = commands.createElement("Open");
        open.appendChild(commands.createTextNode("\nOpen Door \n"));
        open.appendChild(commands.createTextNode("Open PC \n"));
        open.appendChild(commands.createTextNode("Open Inventory \n"));

        Element pickup = commands.createElement("Pickup");
        pickup.appendChild(commands.createTextNode("\nPickup \n"));

        root.appendChild(movement);
        root.appendChild(go);
        root.appendChild(open);
        root.appendChild(pickup);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(commands);

        StreamResult result = new StreamResult("C:\\Users\\Giatzo\\IdeaProjects\\ZorkProject\\src\\commands.xml");
        transformer.transform(source,result);
    }

}
