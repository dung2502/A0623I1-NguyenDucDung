package javaIO.copyfile;

import java.io.*;

public class CopyFile {
    public static final String FILE_READ = "E:\\Code_Gym\\Module2\\Code_Module2\\src\\javaIO\\copyfile\\source.txt";
    public static final String FILE_WRITE = "E:\\Code_Gym\\Module2\\Code_Module2\\src\\javaIO\\copyfile\\target.txt";

    public static void copyFILE(){
        try {
            File fileRead = new File(FILE_READ);
            if (!fileRead.exists()){
                throw new FileNotFoundException();
            }
            File fileWrite = new File(FILE_WRITE);
            if (!fileWrite.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader bufferRead = new BufferedReader( new FileReader(fileRead));
            BufferedWriter bufferWrite = new BufferedWriter( new FileWriter(fileWrite));

            int cout = 0;
            String line = "";
            while((line = bufferRead.readLine()) != null){
                System.out.println(line);
                cout = Char(line);
                bufferWrite.write(line + "\n");
            }
            bufferWrite.write("Character num: " + cout);
            bufferRead.close();
            bufferWrite.close();
        }
        catch (Exception e){
            System.out.println("Have a Bug");
        }
    }
    public static int Char(String line){
        String[] array = line.split(" ");
        int count = 0;
        for (String a: array){
            count += a.length();
        }
        return count;
    }

    public static void main(String[] args) {
        copyFILE();
    }
}
