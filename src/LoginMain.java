import java.io.*;
import java.util.Scanner;

public class LoginMain {

    private String file_name;
    //private String key;

    public LoginMain(String file_name){
        //this.key = key;
        this.file_name = file_name;
    }

    public void getFile(){
        // Finds text file associated with file_name
        // Raise error/ask to create file if file does not exist
        try {
            BufferedReader in_file = new BufferedReader(new FileReader(this.file_name));
            Scanner s = new Scanner(in_file);
            String key = s.nextLine();
            while(s.hasNextLine()){
                String line = s.nextLine();
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }

    }

    public void setFile(){
        // Creates new text file and its associated file_name
        // Checks if the file already exists
        try {
            File new_file = new File(this.file_name);
            boolean created = new_file.createNewFile();

            if (created){}

        } catch(IOException e){
            System.out.println(e);
        }
    }

    public void editFile(){

    }

}
