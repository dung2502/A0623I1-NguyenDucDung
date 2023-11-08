package Javacollectionframework.dao;


import Javacollectionframework.dto.Product;

public interface ProductRepository {
    int getSize();
    void addProduct(Product product);
    void setProduct(String id);
    Product removeProduct(String idRemove);
    void displayProduct();
    Product searchProduct(String name);
    Product searchProductById(String id);
    void sortProductList();
}