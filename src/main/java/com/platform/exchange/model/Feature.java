package com.platform.exchange.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "feature")
public class Feature {

    @Id
    private UUID id;

    private String key;

    private String value;

    private String productUUID;

    public Feature() {
    }

    public Feature(UUID id, String key, String value, String productUUID) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.productUUID = productUUID;
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

    public String getProductUUID() {
        return productUUID;
    }

    public void setProductUUID(String productUUID) {
        this.productUUID = productUUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feature feature = (Feature) o;
        return Objects.equals(id, feature.id) &&
                Objects.equals(key, feature.key) &&
                Objects.equals(value, feature.value) &&
                Objects.equals(productUUID, feature.productUUID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, key, value, productUUID);
    }
}
