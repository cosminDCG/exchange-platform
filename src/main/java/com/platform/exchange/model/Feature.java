package com.platform.exchange.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "feature")
public class Feature {

    @Id
    private UUID id;

    private String key;

    private String value;

    @ManyToOne
    @JoinColumn(name = "product_uuid")
    private Product product;

    public Feature() {
    }

    public Feature(UUID id, String key, String value, Product product) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.product = product;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feature feature = (Feature) o;
        return Objects.equals(id, feature.id) &&
                Objects.equals(key, feature.key) &&
                Objects.equals(value, feature.value) &&
                Objects.equals(product, feature.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, key, value, product);
    }
}
