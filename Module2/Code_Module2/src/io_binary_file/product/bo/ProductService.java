package io_binary_file.product.bo;

import io_binary_file.product.dto.Product;

public interface ProductService {
    void addProduct(Product product);
    void setProduct(int id);
    void removeProduct(int id);
    void showProduct();
    void searchProduct(String name);
}
