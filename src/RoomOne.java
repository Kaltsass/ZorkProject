import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
/*public class RoomOne {
    public  static void main(String [] args)throws Exception {
        List<String> randomElements = rndSelectionItems.getRandomElements("C:\\Users\\lange\\IdeaProjects\\tests\\Zorkv_1\\src\\items.xml");
        writeItemsToXml(randomElements, "C:\\Users\\lange\\IdeaProjects\\tests\\Zorkv_1\\src\\RoomItems.xml");
    }

        public static void   writeItemsToXml(List<String> items, String filePath)throws Exception{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("Items");
            doc.appendChild(rootElement);

            Element pickables = doc.createElement("pickables");
            rootElement.appendChild(pickables);


            for (String item: items) {
                Element itemElement = doc.createElement("item");
                itemElement.appendChild(doc.createTextNode(item));
                pickables.appendChild(itemElement);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\lange\\IdeaProjects\\tests\\Zorkv_1\\src\\RoomItems.xml"));
            transformer.transform(source,result);



        }

    }
*/
public class RoomOne{
    public static void main(String[] args)throws Exception{
        rndSelectionItems.main(args);

        List<Element> randomElements = rndSelectionItems.getRandomElements();
        Element defaultElement = rndSelectionItems.getDefaultElement();

        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element rootElement = document.createElement("roomOneItems");
        document.appendChild(rootElement);

        Element defaultElementClone = (Element) document.importNode(defaultElement,true);

        for(Element element: randomElements){
            Element clonedElement = (Element) document.importNode(element,true);
            rootElement.appendChild(clonedElement);
        }

        File outputFile = new File("C:\\Users\\lange\\IdeaProjects\\tests\\Zorkv_1\\src\\RoomItems.xml");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource  = new DOMSource(document);
        StreamResult streamResult  = new StreamResult(outputFile);

        transformer.transform(domSource,streamResult);
        System.out.println("roomOneItems.xml has been created succesfully");
    }
}

