package javaIO.test2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class test2 {
    public static final String FILE_PATH_READ = "E:\\Code_Gym\\Module2\\Code_Module2\\src\\javaIO\\test2\\number.txt";
    public static final String FILE_PATH_WRITE = "E:\\Code_Gym\\Module2\\Code_Module2\\src\\javaIO\\test2\\result1.txt";

    public static List<Integer> readFile(){
        List<Integer> number = new ArrayList<>();
        try {
            File file = new File(FILE_PATH_READ);
            if (!file.exists()){
                throw new FileNotFoundException();
            }

            BufferedReader buffer = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = buffer.readLine()) != null){
                    number.add(Integer.parseInt(line));
            }
            buffer.close();
        }
        catch (Exception e){
            System.out.println("Have a BUG");
        }
        return number;
    }
    private static void writeFile(int number){
        try {
            File file = new File(FILE_PATH_WRITE);
            if (!file.exists()){
                throw  new FileNotFoundException();
            }
            BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
            buffer.write(String.valueOf(number));
            buffer.close();
        }catch (Exception e){
            System.out.println("Have a BUG 2");
        }
    }
    public static int findMax(List<Integer> number){
        int max = number.get(0);

        for (int i = 1; i < number.size(); i++){
            if(number.get(i) > max){
                max = number.get(i);
            }
        }
        return max;
    }
    public static void read(){
        try {
            File file = new File(FILE_PATH_WRITE);
            if (!file.exists()){
                throw new FileNotFoundException();
            }

            BufferedReader buffer = new BufferedReader(new FileReader(file));
            String line = "";

            while ((line = buffer.readLine()) != null){
                System.out.println(line);
            }
            buffer.close();
        }
        catch (Exception e){
            System.out.println("Have a BUG");
        }
    }

    public static void main(String[] args) {
        List<Integer> number = readFile();
        int value = findMax(number);
        writeFile(value);
        read();
    }
}
