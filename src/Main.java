import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int welcomingCallCount =welcoming.getCallCount();
        if(welcomingCallCount==0){
            welcoming.main(args);
            System.out.println("\n");
        }
        welcoming.resetCallCount();

        //keyboard input stored
        Scanner keyboardInput = new Scanner(System.in);
        String userInput =keyboardInput.nextLine();


        //Available commands displayed below when userInputs == help
        if(userInput.equals("help") || userInput.equals("/help")){
            try {
                helpXmlReader.main(args);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}