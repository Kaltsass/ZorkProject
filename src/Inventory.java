import java.util.Hashtable;

public class Inventory {
    public static Hashtable<String, String> createInventory() {
        Hashtable<String, String> letters = new Hashtable<>();
        // Add logic to populate the Hashtable dynamically
        // For demonstration purposes, let's add some sample data
        letters.put("Key1", "Value1");
        letters.put("Key2", "Value2");
        letters.put("Key3", "Value3");
        return letters;
    }
}
