import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        //int welcomingCallCount =welcoming.getCallCount();
        //if(welcomingCallCount==0){
            FileChecker.main(args);
            welcoming.main(args);
            System.out.println("\n");
        //}
        //welcoming.resetCallCount();

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\lange\\IdeaProjects\\tests\\Zorkv_1\\src\\LoadingGame.txt"));
        //keyboard input stored
        Scanner keyboardInput = new Scanner(System.in);
        String userInput =keyboardInput.nextLine();
        while(userInput!=null) {
            writer.write(userInput);
            writer.write("\n");


            //Available commands displayed below when userInputs == help
            if (userInput.equals("help") || userInput.equals("/help")) {
                try {
                    helpXmlReader.main(args);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}