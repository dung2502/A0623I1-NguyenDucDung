package io_binary_file.product.dto;

import org.jetbrains.annotations.NotNull;

public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private String producer;
    private int salary;
    private String describe;

    public Product() {
    }

    public Product(int id, String name, String producer, int salary, String describe) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.salary = salary;
        this.describe = describe;
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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public int compareTo(Product o) {
        return Integer.compare(this.salary, o.salary);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", salary=" + salary +
                ", describe='" + describe + '\'' +
                '}';
    }
}
