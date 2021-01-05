import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginMain {

    private String file_name;
    private ArrayList<String> array;
    private int key;

    public LoginMain(String file_name){
        this.key = 79;
        this.file_name = file_name + ".txt";
        this.array = new ArrayList();

    }

    public String getFile(){
        // Finds text file associated with file_name
        // Raise error/ask to create file if file does not exist
        try {
            BufferedReader in_file = new BufferedReader(new FileReader(this.file_name));
            Scanner s = new Scanner(in_file);
            while(s.hasNextLine()){
                String line = s.nextLine();
                //if(!line.matches("\\S* \\S* \\S*")){
                    //return "bad_file";
                //}
                this.array.add(line);
            }
            s.close();
        }
        catch (FileNotFoundException e){
            return "no_file";
        }
        return "good_file";
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
            encryptArray();
            File out_file = new File(this.file_name);
            BufferedWriter out = new BufferedWriter(new FileWriter(out_file));
            if(out_file.exists()) {
                for(String i: this.array){

                    if(!i.equals("  ")) {
                        out.write(i);
                        out.write("\n");
                    }
                }
            }
            out.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public ArrayList<String> getArray(){
        this.decryptArray();
        return this.array;
    }

    public void setArray(ArrayList<String> new_array){
        this.array = new_array;
    }

    public void encryptArray(){
        for(int i = 0; i < this.array.size(); i++){
            char[] char_arr  = this.array.get(i).toCharArray();
            for(int j =0; j < char_arr.length; j++){
                char_arr[j] += this.key;
            }
            this.array.set(i, String.valueOf(char_arr));
        }
    }

    public void decryptArray(){
        for(int i = 0; i < this.array.size(); i++){
            char[] char_arr  = this.array.get(i).toCharArray();
            for(int j =0; j < char_arr.length; j++){
                char_arr[j] -= this.key;
            }
            this.array.set(i, String.valueOf(char_arr));
        }
    }


}
