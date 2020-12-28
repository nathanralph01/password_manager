import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginMain {

    private String file_name;
    private ArrayList<String> array;
    //private String key;

    public LoginMain(String file_name){
        //this.key = key;
        this.file_name = file_name;
        this.array = new ArrayList();
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
                this.array.add(line);
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

            if (created){
                // Write to file
                BufferedWriter out_file = new BufferedWriter(new FileWriter(new_file));
                out_file.write("Hello there");
            }
            else{
                System.out.println("The file: " + this.file_name + " already exists");
            }

        } catch(IOException e){
            System.out.println(e);
        }
    }

    public void editFile(String input_text){

    }



}
