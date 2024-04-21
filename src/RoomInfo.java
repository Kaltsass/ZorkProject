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
public class RoomInfo {


    public static void  main (String[] args)throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document info = builder.newDocument();

        Element root = info.createElement("Information");
        info.appendChild(root);

        Element roomName = info.createElement("NameOfRoom");
        roomName.appendChild(info.createTextNode("\nRoom1\n"));
        roomName.appendChild(info.createTextNode("Room2\n"));
        roomName.appendChild(info.createTextNode("Room3\n"));
        roomName.appendChild(info.createTextNode("Room4\n"));
        roomName.appendChild(info.createTextNode("SecretRoom\n"));

        Element roomDesc = info.createElement("RoomDescreption");
        roomDesc.appendChild(info.createTextNode("\ndesc1\n"));
        roomDesc.appendChild(info.createTextNode("desc2\n"));
        roomDesc.appendChild(info.createTextNode("desc3\n"));
        roomDesc.appendChild(info.createTextNode("desc4\n"));
        roomDesc.appendChild(info.createTextNode("secretDesc\n"));

        Element availableDir = info.createElement("AvailableDirections");
        availableDir.appendChild(info.createTextNode("\nForward\n"));
        availableDir.appendChild(info.createTextNode("Left\n"));
        availableDir.appendChild(info.createTextNode("Right\n"));
        availableDir.appendChild(info.createTextNode("BacK\n"));

        root.appendChild(roomName);
        root.appendChild(roomDesc);
        root.appendChild(availableDir);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(info);

        StreamResult result = new StreamResult("C:\\Users\\lange\\IdeaProjects\\tests\\Zorkv_1\\src\\RoomInfo.xml");
        transformer.transform(source,result);


    }
}
