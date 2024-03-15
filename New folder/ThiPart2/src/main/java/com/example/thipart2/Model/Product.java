package com.example.thipart2.Model;

public class Product {
    private int id;
    private String product_name;
    private double price;
    private int quantity;
    private String color;
    private int category_code;

    public Product() {
    }

    public Product(String product_name, double price, int quantity, String color, int category_code) {
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category_code = category_code;
    }

    public Product(int id, String product_name, double price, int quantity, String color, int category_code) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category_code = category_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCategory_code() {
        return category_code;
    }

    public void setCategory_code(int category_code) {
        this.category_code = category_code;
    }
}
