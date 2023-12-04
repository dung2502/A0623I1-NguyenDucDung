package javacollectionframework.services;

import javacollectionframework.model.Product;


public interface ProductService {
    void addProduct(Product product);
    void editProduct(Product product);
    void removeProduct(Product product);
    void displayProduct();
    Product searchProduct(String id);

}