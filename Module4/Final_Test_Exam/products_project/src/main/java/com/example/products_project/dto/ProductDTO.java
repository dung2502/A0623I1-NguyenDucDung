package com.example.products_project.dto;


import com.example.products_project.model.Category;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



public class ProductDTO implements Validator {
    private Integer productId;
    //    @NotBlank(message = "Cannot be left blank!")
//    @Pattern(regexp = "^[a-zA-Z0-9\\s-]{4,50}$", message = "The name is not in the correct format and cannot be blank!. Ex: Samsung 123")
    private String productName;

    private double price;
    private boolean status;

    private Category category;

    public ProductDTO() {
    }

    public ProductDTO(Integer productId, String productName, double price, boolean status, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.status = status;
        this.category = category;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDTO productDTO = (ProductDTO) target;
        if(productDTO.getPrice() < 100000) {
            errors.rejectValue("price", "", "The price cannot be too low, the minimum is 100,000 VNĐ!");
        }


    }
    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", category=" + category +
                '}';
    }
}
