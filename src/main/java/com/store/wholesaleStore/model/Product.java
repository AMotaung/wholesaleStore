package com.store.wholesaleStore.model;

import javax.persistence.*;

@Table(name = "product")
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private double price;
    private String description;
    private String specification;
    private String photo;
    private int quantity;
    private String createdAt;
    private String modified;

    public Product() {
        super();
    }

    public Product(int productId, String productName, double price, String description, String specification, String photo, int quantity, String createdAt, String modified) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.specification = specification;
        this.photo = photo;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.modified = modified;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", specification='" + specification + '\'' +
                ", photo='" + photo + '\'' +
                ", quantity=" + quantity +
                ", createdAt='" + createdAt + '\'' +
                ", modified='" + modified + '\'' +
                '}';
    }
}
