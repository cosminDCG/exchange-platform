package com.platform.exchange.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
    }

    public UserNotFoundException(ErrorMessage message) {
        super(message.getMessage());
    }
}
