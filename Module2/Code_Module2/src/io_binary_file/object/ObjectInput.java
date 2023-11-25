package io_binary_file.object;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInput {
    public static final String LINK = "E:\\Code_Gym\\Module2\\Code_Module2\\src\\io_binary_file\\object\\abc.txt";

    public static void main(String[] args) throws IOException {
        ObjectInputStream test = null;
        try {
            test = new ObjectInputStream(new FileInputStream(LINK));
            Product product = (Product) test.readObject();
            System.out.println(product);

        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            test.close();
        }

    }
}
