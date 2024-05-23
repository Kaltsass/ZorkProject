import javax.xml.parsers.ParserConfigurationException;
import java.util.Hashtable;

public class MovementCreation {

    static int moveF, moveL, moveR, moveB, moveUp, moveD, openD, openPc, openInv = 0;
    static String pickupItem;
    static int currentRoomIndex = 0;
    static final int TOTAL_ROOMS = 5;
    static RoomsAttempt[] rooms = new RoomsAttempt[TOTAL_ROOMS];

    static {
        for (int i = 0; i < TOTAL_ROOMS; i++) {
            rooms[i] = new RoomsAttempt();
        }
    }

    public static void handleCommand(String command, Hashtable<String, String> letters) throws ParserConfigurationException {
        switch (command.toLowerCase()) {
            case "move forward":
                System.out.println("You chose to move forward.");
                moveF++;
                if (rooms[currentRoomIndex].movePlayer("MOVE FORWARD")) {
                    goToNextRoom();
                }
                break;
            case "move left":
                System.out.println("You chose to move left.");
                moveL++;
                if (rooms[currentRoomIndex].movePlayer("MOVE LEFT")) {
                    goToNextRoom();
                }
                break;
            case "move right":
                System.out.println("You chose to move right.");
                moveR++;
                if (rooms[currentRoomIndex].movePlayer("MOVE RIGHT")) {
                    goToNextRoom();
                }
                break;
            case "move back":
                System.out.println("You chose to move back.");
                moveB++;
                if (rooms[currentRoomIndex].movePlayer("MOVE BACK")) {
                    goToNextRoom();
                }
                break;
            case "go upstairs":
                System.out.println("You chose to go upstairs.");
                moveUp++;
                break;
            case "go downstairs":
                System.out.println("You chose to go downstairs.");
                moveD++;
                break;
            case "open door":
                System.out.println("You chose to open the door.");
                openD++;
                break;
            case "open pc":
                System.out.println("You chose to open the PC.");
                openPc++;
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
                break;
            default:
                System.out.println("Invalid command.");
                break;
        }
    }

    private static void goToNextRoom() {
        if (currentRoomIndex < TOTAL_ROOMS - 1) {
            currentRoomIndex++;
            System.out.println("Entering room " + (currentRoomIndex + 1));
            rooms[currentRoomIndex].initializeMap();
        } else {
            System.out.println("Congratulations! You have completed all rooms!");
        }
    }

    public static void displayCurrentRoom() {
        rooms[currentRoomIndex].displayMap();
    }
}
