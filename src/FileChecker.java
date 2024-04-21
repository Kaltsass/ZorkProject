import java.io.File;

public class FileChecker {

    public  static void main (String[] args)throws Exception{
        File file = new File("C:\\Users\\lange\\IdeaProjects\\tests\\Zorkv_1\\src\\LoadingGame.txt");   //Txt pou tha ginontai save ta commands

        if(file.exists() && !file.isDirectory()){
            if(file.length()==0) {
                // call welcoming.java
                welcoming.main(args);
            }else{
                //ask for a load or a new game
                //parse txt LoadingGame and type 1 by 1 in the terminal
            }
        }
    }
}
