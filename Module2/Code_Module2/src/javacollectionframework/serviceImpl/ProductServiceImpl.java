package javacollectionframework.serviceImpl;


import javacollectionframework.model.Product;
import javacollectionframework.services.ProductService;

import java.io.*;
import java.util.*;

public class ProductServiceImpl implements ProductService {
    Scanner sc = new Scanner(System.in);
    private static final List<Product> productsList;
    private static final String PATH = "E:\\Code_Gym\\Module2\\Code_Module2\\src\\javacollectionframework\\data\\abc.csv";
    static {
        productsList = readFromFile();
    }
    @Override
    public void addProduct(Product product) {
        if (searchProduct(product.getId()) == null){
            productsList.add(product);
            writeToFile(product);
            System.out.println("Add completed!");
        } else {
            System.out.println("Add Fail!");
        }
    }

    @Override
    public void editProduct(Product product) {
        boolean check = false;
        do {
            try{
                System.out.println("--------Customer---Found--------");
                System.out.println("1. Edit name: ");
                System.out.println("2. Edit id: ");
                System.out.println("3. Edit price: ");
                System.out.println("0. Exit");
                System.out.println("Enter your chose: ");
                int chose = Integer.parseInt(sc.nextLine());
                switch (chose){
                    case 1:
                        System.out.println("Enter new name: ");
                        String name = sc.nextLine();
                        product.setName(name);
                        updateFile(product,"edit");
                        break;
                    case 2:
                        System.out.println("Enter new phone number: ");
                        String id = sc.nextLine();
                        product.setId(id);
                        updateFile(product,"edit");
                        break;
                    case 3:
                        System.out.println("Enter new price: ");
                        int price = sc.nextInt();
                        product.setPrice(price);
                        updateFile(product,"edit");
                        break;
                    case 0:
                        System.exit(0);
                }
            }catch (InputMismatchException e){
                System.out.println("Plead enter a valid: ");
            }
        }while (check);

    }

    @Override
    public void removeProduct(Product product) {
        updateFile(product, "remove");
        productsList.remove(product);

    }

    @Override
    public void displayProduct() {
        if (!productsList.isEmpty()){
            for (Product product: productsList) {
                System.out.println(product);
            }
        }

    }

    @Override
    public Product searchProduct(String id) {
        for (Product product : productsList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public static List<Product> readFromFile() {
        List<Product> products = new ArrayList<>();
        try {
            File file = new File(PATH);
            if (!file.exists()){
                throw new FileNotFoundException("File not found");
            }
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            while( (line = br.readLine()) != null){
                String[] array = line.split(",");
                String name = array[0];
                String id = array[1];
                int price = Integer.parseInt(array[2]);
                Product customer = new Product(name, id, price);
                products.add(customer);
            }
            System.out.println("LOADING================");
            System.out.println("Successfully");
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IO EXCEPTION");
        }
        return products;
    }
    public void writeToFile(Product product) {
        try{
            File file = new File(PATH);
            if (!file.exists()){
                throw new FileNotFoundException(" File not found ! ");
            }
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(writer);
                bw.newLine();
                bw.write(product.toString());
                bw.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IOEXCEPTION");
        }
    }
    private void updateFile(Product p, String update){
        try {
            File InFile = new File(PATH);
            File TFile = new File("tfile.csv");
            if(!InFile.exists()){
                System.out.println("File not found! ");
            }
            if (!TFile.exists()){
                System.out.println("Temp file exist! ");
            }
            BufferedReader reader = new BufferedReader(new FileReader(InFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(TFile));

            String Line;

            while ((Line = reader.readLine()) != null) {
                String[] arr = Line.split(",");
                int id = Integer.parseInt(arr[1]);
                if (Objects.equals(id, p.getId())) {
                    if (Objects.equals(update, "edit")){
                        writer.write(p + "\n");
                        System.out.println("Update successful!");
                    } else if (Objects.equals(update, "remove")){
                        System.out.println("Deleted product name in file!");
                    }
                } else {
                    writer.write(Line + "\n");
                }
            }
            writer.close();
            reader.close();
            if (!InFile.delete()) {
                System.out.println("Error deleting original file");
                return;
            }
            if (!TFile.renameTo(InFile)) {
                System.out.println("Error renaming temporary file");
            }
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        ProductService a = new ProductServiceImpl();
        a.displayProduct();
        Product product = new Product("BGGT", "0123", 12314);
        a.addProduct(product);
        System.out.println("\n");
        a.displayProduct();
    }
}