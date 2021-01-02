package com.platform.exchange.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {

    }

    public ProductNotFoundException(ErrorMessage message) {
        super(message.getMessage());
    }
}
