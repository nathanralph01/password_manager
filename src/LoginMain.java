import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class LoginMain {

    private String key;

    public LoginMain(String key){
        this.key = key;
    }

    public void getFile(){
        // Finds text file associated with key
        // Raise error/ask to create file if file does not exist
        try {
            BufferedReader in_file = new BufferedReader(new FileReader(this.key));
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }

    }

    public void setFile(){
        // Creates new text file and its associated key
        // Checks if the key already exists
    }

}
