import java.io.File;

public class FileChecker {

    public  static void main (String[] args){
        File file = new File(".txt");   //Txt pou tha ginontai save ta commands

        if(file.exists() && !file.isDirectory()){
            if(file.length()==0) {
                System.out.println("123");
            }else{
                System.out.println("1233131");
            }
        }
    }
}
