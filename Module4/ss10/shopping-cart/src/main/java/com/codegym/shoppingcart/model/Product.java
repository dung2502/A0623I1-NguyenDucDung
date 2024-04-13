package com.codegym.shoppingcart.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "product_code", unique = true)
    private String productCode;
    @Column(name = "product_name")
    private String name;
    @Column(name = "old_price")
    private double oldPrice;
    @Column(name = "new_price")
    private double newPrice;
    @Column(name = "product_description",columnDefinition = "TEXT")
    private String description;
    private String image;

    public Product() {
    }

    public Product(String productCode, String name, double oldPrice, double newPrice, String description, String image) {
        this.productCode = productCode;
        this.name = name;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.description = description;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
