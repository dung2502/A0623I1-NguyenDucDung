package io_binary_file.product.bo;

import io_binary_file.product.dao.ProductRepository;
import io_binary_file.product.dao.ProductRepositoryImpl;
import io_binary_file.product.dto.Product;

public class ProductServiceImpl implements ProductService{
    private  final ProductRepository Repository = new ProductRepositoryImpl();



    @Override
    public void addProduct(Product product) {
        Repository.addProduct(product);
        System.out.println("Product add successfully! ");
    }

    @Override
    public void setProduct(int id) {
        if (Repository.SearchProductById(id) != null ){
            Repository.setProduct(id);
            System.out.println("Set Product successfully!");
        }
    }

    @Override
    public void removeProduct(int id) {
        if (Repository.removeProduct(id) != null){
            Product product = Repository.removeProduct(id);
            System.out.println(" This Product is remove! ");
            return;
        }
    }

    @Override
    public void showProduct() {
        if (Repository.getSize() != 0){
            Repository.showProduct();
            return;
        }
        System.out.println("Empty List");

    }

    @Override
    public void searchProduct(String name) {
        Product product = Repository.searchProduct(name);
        if (product != null){
            System.out.println(product);
        }
        else {
            System.out.println(" Not Found!! ");
        }
    }
}
