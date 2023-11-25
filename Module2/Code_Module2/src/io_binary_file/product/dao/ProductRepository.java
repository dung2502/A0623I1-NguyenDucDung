package io_binary_file.product.dao;

import io_binary_file.product.dto.Product;


public interface ProductRepository {

    int getSize();
    void addProduct(Product product);
    void setProduct(int id);
    void showProduct();
    Product removeProduct(int id);
    Product searchProduct (String name);
    Product SearchProductById(int id);
    void sortProductList();

}
