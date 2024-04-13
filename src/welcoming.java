import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class welcoming {
    private static int callCount = 0;

    //below will be the creation and storage of the entering displayable message for the player to read
    public static void  main(String [] args)throws Exception{
        callCount++;

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\lange\\IdeaProjects\\tests\\Zorkv_1\\src\\welcome.txt"));
        writer.write("welcoming text");
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\lange\\IdeaProjects\\tests\\Zorkv_1\\src\\welcome.txt"));
        System.out.println(reader.readLine());
        reader.close();

    }
    public static int getCallCount(){
        return callCount;
    }
    public static void resetCallCount(){
        callCount = 0;
    }
}
