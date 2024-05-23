import java.util.Hashtable;

public class Inventory {
    public static Hashtable<String, String> createInventory() {
        Hashtable<String, String> letters = new Hashtable<>();
        // Add logic to populate the Hashtable dynamically
        // For demonstration purposes, let's add some sample data
        letters.put("Letter1", "Value5");
        letters.put("Letter2", "Value4");
        letters.put("Letter3", "Value3");
        letters.put("Letter4", "Value2");
        letters.put("Letter5", "Value1");
        return letters;
    }
}
