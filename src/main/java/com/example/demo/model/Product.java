package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String productDescription;
    private double productPrice;

    @Enumerated(EnumType.STRING)
    private Size productSize;

    @Enumerated(EnumType.STRING)
    private Category productCategory;

    private String productImage;

    public enum Size {
        XS("Extra Small"),
        S("Small"),
        M("Medium"),
        L("Large"),
        XL("Extra Large"),
        XXL("Double Extra Large");

        private final String displayName;

        Size(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public enum Category {
        T_SHIRTS("T-Shirts"),
        HOODIES("Hoodies");

        private final String displayName;

        Category(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public Product() {

    }

    public Product(String productName, String productDescription, double productPrice, Size productSize,
                   Category productCategory, String productImage) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productSize = productSize;
        this.productCategory = productCategory;
        this.productImage = productImage;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Size getProductSize() {
        return productSize;
    }

    public void setProductSize(Size productSize) {
        this.productSize = productSize;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category category) {
        this.productCategory = category;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
