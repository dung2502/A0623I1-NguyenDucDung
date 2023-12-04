package test_module2.serviceImpl;

import test_module2.model.Customer;
import test_module2.services.CustomerServices;

import java.io.*;
import java.util.*;

public class CustomerServiceImpl implements CustomerServices {
    Scanner sc = new Scanner(System.in);
    private final List<Customer> customersList = new ArrayList<>();
    private final List<Customer> temporaryMemory = new ArrayList<>();
    private static final String PATH = "E:\\Code_Gym\\Module2\\Code_Module2\\src\\test_module2\\data\\customer.csv";


    @Override
    public void showCustomer() {
        if (!customersList.isEmpty()){
            for (Customer customer: customersList){
                System.out.println(customer);
            }
        }
    }

    @Override
    public boolean addNew(Customer c) {
        for (Customer customer : customersList){
            if (!customer.getPhoneNumber().equals(c.getPhoneNumber())){
                customersList.add(c);
                temporaryMemory.add(c);
                return true;
            }
        }
        return false;
    }


    @Override
    public void editCustomer(Customer c) {
        boolean check = false;
        do {
            check = true;
            try {
                System.out.println("--------Customer---Found--------");
                System.out.println("1. Edit name: ");
                System.out.println("2. Edit phone number: ");
                System.out.println("3. Edit address: ");
                System.out.println("4. Edit email: ");
                System.out.println("5. Edit facebook: ");
                System.out.println("6. Edit gender: ");
                System.out.println("7. Edit date of birth: ");
                System.out.println("8. Edit group of phone number: ");
                System.out.println("0. Exit");
                System.out.println("Enter your chose: ");
                int chose = Integer.parseInt(sc.nextLine());
                switch (chose){
                    case 1:
                        System.out.println("Enter new name: ");
                        String name = sc.nextLine();
                        c.setName(name);
                        updateFile(c, "edit");
                        break;
                    case 2:
                        System.out.println("Enter new phone number: ");
                        String phone = sc.nextLine();
                        c.setPhoneNumber(phone);
                        updateFile(c, "edit");
                        break;
                    case 3:
                        System.out.println("Enter new address: ");
                        String address = sc.nextLine();
                        c.setAddress(address);
                        updateFile(c, "edit");
                        break;
                    case 4:
                        System.out.println("Enter new email: ");
                        String email = sc.nextLine();
                        c.setEmail(email);
                        updateFile(c, "edit");

                        break;
                    case 5:
                        System.out.println("Enter new facebook: ");
                        String facebook = sc.nextLine();
                        c.setFacebook(facebook);
                        updateFile(c, "edit");

                        break;
                    case 6:
                        System.out.println("Enter new gender: ");
                        String gender = sc.nextLine();
                        c.setGender(gender);
                        updateFile(c, "edit");

                    case 7:
                        System.out.println("Enter new date of birth: ");
                        String date = sc.nextLine();
                        c.setDateOfBirth(date);
                        updateFile(c, "edit");

                    case 8:
                        System.out.println("Enter new group of phone number: ");
                        int group = sc.nextInt();
                        c.setGroupOfPhoneNumber(group);
                    case 0:
                        check = false;

                }
            }
            catch (InputMismatchException e){
                System.out.println("Pleased enter a valid: ");
            }
        }while (check);
    }

    @Override
    public void removeCustomer(Customer c) {
        updateFile(c, "remove");
        customersList.remove(c);


    }


    @Override
    public Customer search(String phone) {
        if (!customersList.isEmpty()){
            for (Customer customer: customersList) {
                if (customer.getPhoneNumber().equals(phone) )
                {
                    return customer;
                }
            }
        }

        return null;
    }

    @Override
    public List<Customer> readFile() {
        List<Customer> customers = new ArrayList<>();
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
                String phoneNumber = array[1];
                String address =  array[2];
                String email = array[3];
                String facebook = array[4];
                String gender =array[5];
                String dateOfBirth = array[6];
                int groupPhoneNumber = Integer.parseInt(array[7]);
                Customer customer = new Customer(name, phoneNumber, address, email, facebook, gender, dateOfBirth, groupPhoneNumber);
                customersList.add(customer);
            }
            System.out.println("LOADING================");
            System.out.println("Successfully");
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IO EXCEPTION");
        }
        return customers;
    }

    @Override
    public void writeFile() {
        try{
            File file = new File(PATH);
            if (!file.exists()){
                throw new FileNotFoundException(" File not found ! ");
            }
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(writer);
            for (Customer c: temporaryMemory) {
                bw.newLine();
                bw.write(c.toString());
            }
            temporaryMemory.clear();
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IOEXCEPTION");
        }
    }
    private void updateFile(Customer c, String update){
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
                String phone = arr[1];
                if (Objects.equals(phone, c.getPhoneNumber())) {
                    if (Objects.equals(update, "edit")){
                        writer.write(c + "\n");
                        System.out.println("Update successful!");
                    } else if (Objects.equals(update, "remove")){
                        System.out.println("Deleted customer name in file!");
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
        }
