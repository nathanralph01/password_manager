import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginMain {

    private String file_name;
    private ArrayList<String> array;
    //private String key;

    public LoginMain(String file_name){
        //this.key = key;
        this.file_name = file_name + ".txt";
        this.array = new ArrayList();

    }

    public void getFile(){
        // Finds text file associated with file_name
        // Raise error/ask to create file if file does not exist
        try {
            BufferedReader in_file = new BufferedReader(new FileReader(this.file_name));
            Scanner s = new Scanner(in_file);
            while(s.hasNextLine()){
                String line = s.nextLine();
                this.array.add(line);
            }
            s.close();
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

            if(!created){
                System.out.println("The file: " + this.file_name + " already exists");
            }

        } catch(IOException e){
            System.out.println(e);
        }
    }

    public void editFile(){
        try{
            int cnt = 0;
            File out_file = new File(this.file_name);
            BufferedWriter out = new BufferedWriter(new FileWriter(out_file));
            if(out_file.exists()) {
                for(String i: this.array){

                    if(this.array.get(cnt) != "  ") {
                        out.write(this.array.get(cnt));
                        out.write("\n");
                    }

                    cnt += 1;
                }

            }
            out.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public ArrayList<String> getArray(){
        return this.array;
    }

    public void setArray(ArrayList<String> new_array){
        this.array = new_array;
    }

    /*
    public static void main(String[] args){
        LoginMain temp = new LoginMain("tempfile");
        temp.getFile();
        ArrayList<String> temp_array = new ArrayList();
        temp_array.add("for");
        temp_array.add("five");
        temp_array.add("6ix");
        temp.setArray(temp_array);
        temp.editFile();

    }
     */

}
