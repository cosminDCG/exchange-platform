package com.platform.exchange.exception;

public class OutOfProductsException extends RuntimeException{

    public OutOfProductsException () {

    }

    public OutOfProductsException(ErrorMessage message) {
        super(message.getMessage());
    }
}
