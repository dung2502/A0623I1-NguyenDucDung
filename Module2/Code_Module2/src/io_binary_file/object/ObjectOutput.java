package io_binary_file.object;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutput {
public static final String LINK = "E:\\Code_Gym\\Module2\\Code_Module2\\src\\io_binary_file\\object\\abc.txt";
    public static void main(String[] args) throws IOException {
        ObjectOutputStream test = null;
        try {
            test = new ObjectOutputStream(new FileOutputStream(LINK));
            Product product =  new Product(12, "IP 21", 2000000, "NEW_SPP");
            test.writeObject(product);
            test.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            test.close();
        }
        System.out.println("Complete");
    }
}
