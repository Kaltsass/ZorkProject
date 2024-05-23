import javax.xml.parsers.ParserConfigurationException;
import java.util.Hashtable;

public class MovementCreation {

    static int moveF, moveL, moveR, moveB, moveUp, moveD, openD, openPc, openInv = 0;
    static String pickupItem;

    public static void handleCommand(String command, Hashtable<String, String> letters) throws ParserConfigurationException {
        switch (command.toLowerCase()) {
            case "move forward":
                System.out.println("You chose to move forward.");
                moveF++;
                RoomsAttempt.movePlayer("MOVE FORWARD");
                break;
            case "move left":
                System.out.println("You chose to move left.");
                moveL++;
                RoomsAttempt.movePlayer("MOVE LEFT");
                break;
            case "move right":
                System.out.println("You chose to move right.");
                moveR++;
                RoomsAttempt.movePlayer("MOVE RIGHT");
                break;
            case "move back":
                System.out.println("You chose to move back.");
                moveB++;
                RoomsAttempt.movePlayer("MOVE BACK");
                break;
            case "go upstairs":
                System.out.println("You chose to go upstairs.");
                moveUp++;
                // Add your logic for going upstairs here
                break;
            case "go downstairs":
                System.out.println("You chose to go downstairs.");
                moveD++;
                // Add your logic for going downstairs here
                break;
            case "open door":
                System.out.println("You chose to open the door.");
                openD++;
                // Add your logic for opening the door here
                break;
            case "open pc":
                System.out.println("You chose to open the PC.");
                openPc++;
                // Add your logic for opening the PC here
                break;
            case "open inventory":
                System.out.println("You chose to open the inventory.");
                openInv++;
                letters.clear();
                letters.putAll(Inventory.createInventory());
                for (String key : letters.keySet()) {
                    System.out.println(letters.get(key));
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