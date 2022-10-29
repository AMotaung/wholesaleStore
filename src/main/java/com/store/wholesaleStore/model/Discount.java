package com.store.wholesaleStore.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "discount")
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int discountId;
    private String discountName;
    private String discountDescription;
    private double discountPercentage;
    private boolean active;
    private String createdAt;
    private String modifiedAt;

    @OneToMany(mappedBy = "discount", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products;

    public Discount() {
        super();
    }

    public Discount(int discountId, String discountName, String discountDescription, double discountPercentage, boolean active, String createdAt, String modifiedAt, List<Product> products) {
        this.discountId = discountId;
        this.discountName = discountName;
        this.discountDescription = discountDescription;
        this.discountPercentage = discountPercentage;
        this.active = active;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.products = products;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public String getDiscountDescription() {
        return discountDescription;
    }

    public void setDiscountDescription(String discountDescription) {
        this.discountDescription = discountDescription;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountId=" + discountId +
                ", discountName='" + discountName + '\'' +
                ", discountDescription='" + discountDescription + '\'' +
                ", discountPercentage=" + discountPercentage +
                ", active=" + active +
                ", createdAt='" + createdAt + '\'' +
                ", modifiedAt='" + modifiedAt + '\'' +
                ", products=" + products +
                '}';
    }
}
