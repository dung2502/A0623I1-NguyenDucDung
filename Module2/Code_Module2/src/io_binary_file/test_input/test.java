package io_binary_file.test_input;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class test {
    public  static final String LINK_INPUT = "E:\\Code_Gym\\Module2\\Code_Module2\\src\\io_binary_file\\test_input\\test.txt";
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream(LINK_INPUT);
        int i = -1;

        while( (i = is.read()) != -1){
            System.out.println((char) i);
        }
        is.close();
    }
}
