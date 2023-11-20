package javaIO.test;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class test {

    public static final String FILE_PATH = "E:\\Code_Gym\\Module2\\Code_Module2\\src\\javaIO\\test\\abc.txt";

    public static void read(){
        try {
            File file = new File(FILE_PATH);
            if ( !file.exists()){
                throw new FileNotFoundException();
            }

            BufferedReader buff = new BufferedReader(new FileReader(file));
            String line = "";
            String temp[];
            int sum = 0;
            while ((line = buff.readLine()) != null){
                temp = line.split(",");
                for (int i = 0; i < temp.length; i++){
                    System.out.println(Integer.parseInt(temp[i]));
                    sum += Integer.parseInt(temp[i]);
                }
            }
            buff.close();
            System.out.println("Sum = " + sum);

        }
        catch (Exception e){
            System.out.println("File reader have a bug");
        }



    }

    public static void main(String[] args) {
        read();
    }
}
