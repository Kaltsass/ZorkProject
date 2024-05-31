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

public class availableItems {

    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document items = builder.newDocument();

        Element root = items.createElement("Items");
        items.appendChild(root);


        Element pickable = items.createElement("pickables");
        pickable.appendChild(items.createTextNode("\nPaper\n"));
        pickable.appendChild(items.createTextNode("Key\n"));
        pickable.appendChild(items.createTextNode("Flashlight\n"));
        pickable.appendChild(items.createTextNode("Bottle\n"));   //Incase of a wrong command drink some water to rethink
        pickable.appendChild(items.createTextNode("BikeChain\n"));
        pickable.appendChild(items.createTextNode("USBstick\n"));


        root.appendChild(pickable);

        TransformerFactory transformerFactory =TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        DOMSource source = new DOMSource(items);

        StreamResult result = new StreamResult("C:\\Users\\lange\\IdeaProjects\\tests\\Zorkv_1\\src\\items.xml");
        transformer.transform(source,result);
    }

}