package com.platform.exchange.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {

    @Id
    private UUID id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User seller;

    private String address;

    private Double price;

    private boolean available;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Feature> features;

    public Product() {
    }

    public Product(UUID id, String name, String description, User seller, String address, Double price, boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.seller = seller;
        this.address = address;
        this.price = price;
        this.available = available;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return available == product.available &&
                Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(seller, product.seller) &&
                Objects.equals(address, product.address) &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, seller, address, price, available);
    }
}
