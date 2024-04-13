package com.example.products_project.model;


import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;
    private String productName;
    private double price;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "cagetory_id")
    private Category category;

    public Product() {
    }

    public Product(String productName, double price, boolean status, Category category) {
        this.productName = productName;
        this.price = price;
        this.status = status;
        this.category = category;
    }

    public Product(Integer productId, String productName, double price, boolean status, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.status = status;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
