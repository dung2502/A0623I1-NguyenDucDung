package test_module2.services;


import test_module2.model.Customer;

import java.util.List;

public interface CustomerServices {
    void showCustomer();
    boolean addNew(Customer c);

    void editCustomer(Customer c);
    void removeCustomer(Customer c);
    Customer search(String phone);
    List<Customer> readFile();
    void writeFile();



}
