package com.example.demo1.model;

public class Product {
    private int id;
    private String name;
    private String salary;
    private String info;
    private String producer;

    public Product() {
    }

    public Product(int id, String name, String salary, String info, String producer) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.info = info;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
