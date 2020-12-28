package com.platform.exchange.exception;

public class ExistingUserException extends RuntimeException{

    public ExistingUserException() {

    }

    public ExistingUserException(ErrorMessage message) {
        super(message.getMessage());
    }
}
