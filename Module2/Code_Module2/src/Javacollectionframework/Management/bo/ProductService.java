package Javacollectionframework.bo;

import Javacollectionframework.dto.Product;
public interface ProductService {
    void addProduct(Product product);
    void setProduct(String id);
    void removeProduct(String idRemove);
    void displayProduct();
    void searchProduct(String name);
}