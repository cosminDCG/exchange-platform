package com.platform.exchange.model.product;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ProductType {

    REGULAR("regular"),
    AUTO("auto"),
    REAL_ESTATE("real-estate");

    private final String type;

    ProductType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @JsonCreator
    public static ProductType fromText(String text){
        for(ProductType t : ProductType.values()){
            if(t.getType().equals(text)){
                return t;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return type;
    }
}
