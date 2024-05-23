import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class welcoming {
    private static int callCount = 0;

    //below will be the creation and storage of the entering displayable message for the player to read
    public static void  main(String [] args)throws Exception{
        callCount++;

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Giatzo\\IdeaProjects\\ZorkProject\\src\\welcome.txt"));
        writer.write("Καλώς ήρθες στο \"Το Μυστηριώδες Κτήριο του Πανεπιστημίου\"!\n" +
                "\n" +
                "Είσαι ένας ανυποψίαστος εξερευνητής που έχεις μπει στον λαβύρινθο του πανεπιστημιακού κτηρίου, αλλά η εξέδρα του μυστηρίου σε περιμένει να αποκαλυφθεί. Μετά από μια απρόσμενη ανακάλυψη, συνειδητοποιείς ότι οι πέντε αίθουσες του κτηρίου κρύβουν μια σειρά από γρίφους που πρέπει να λυθούν για να αποκαλυφθούν τα μυστικά τους.\n" +
                "\n" +
                "Μέσα από την πνευματική σου επιδεξιότητα και τη δεινότητά σου στην αναζήτηση λύσεων, πρέπει να διασχίσεις κάθε αίθουσα και να αντιμετωπίσεις τους γρίφους που κρύβονται στο εσωτερικό τους. Μόνο με την επίτευξη των πέντε επαθλών που κρύβονται στο βάθος κάθε αίθουσας, θα μπορέσεις να ξεκλειδώσεις την τελευταία πόρτα που οδηγεί στον υπολογιστή.\n" +
                "\n" +
                "Ετοιμάσου λοιπόν για μια εκπληκτική περιπέτεια στον κόσμο του μυστηρίου και της ανακάλυψης. Οι γρίφοι περιμένουν τον ήρωα που θα τους αποκωδικοποιήσει και θα αποκαλύψει τα μυστικά που κρύβονται στο \"Το Μυστηριώδες Κτήριο του Πανεπιστημίου\"! \n");
        writer.append("A game by LGGG");
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Giatzo\\IdeaProjects\\ZorkProject\\src\\welcome.txt"));
        String line;
        while((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

    }
    public static int getCallCount(){
        return callCount;
    }
    public static void resetCallCount(){
        callCount = 0;
    }
}
