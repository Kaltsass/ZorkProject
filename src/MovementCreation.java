import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.Hashtable;

public class MovementCreation {

    static int moveF,moveL,moveR,moveB,moveUp,moveD,openD,openPc,openInv = 0;
    static String pickupItem;
    public static void handleCommand(String command,Hashtable<String, String> letters) throws ParserConfigurationException {
        switch (command.toLowerCase()) {
            case "move forward":
                System.out.println("You chose to move forward.");
                moveF++;
                // Add your logic for moving forward here
                break;
            case "move left":
                System.out.println("You chose to move left.");
                // Add your logic for moving left here
                moveL++;
                break;
            case "move right":
                System.out.println("You chose to move right.");
                // Add your logic for moving right here
                moveR++;
                break;
            case "move back":
                System.out.println("You chose to move back.");
                // Add your logic for moving back here
                moveB++;
                break;
            case "go upstairs":
                System.out.println("You chose to go upstairs.");
                // Add your logic for going upstairs here
                moveUp++;
                break;
            case "go downstairs":
                System.out.println("You chose to go downstairs.");
                // Add your logic for going downstairs here
                moveD++;
                break;
            case "open door":
                System.out.println("You chose to open the door.");
                // Add your logic for opening the door here
                openD++;
                break;
            case "open pc":
                System.out.println("You chose to open the PC.");
                // Add your logic for opening the PC here
                openPc++;
                break;
            case "open inventory":
                System.out.println("You chose to open the inventory.");
                // Add your logic for opening the inventory here

                letters.clear();
                letters.putAll(Inventory.createInventory());

                // Print the contents of the Hashtable
                for (String key : letters.keySet()) {
                    System.out.println(key + ": " + letters.get(key));
                }


                break;
            case "pickup":
                System.out.println("You chose to pickup.");
                // Add your logic for picking up here
                break;
            default:
                System.out.println("Invalid command.");
                break;
        }





    }
}
