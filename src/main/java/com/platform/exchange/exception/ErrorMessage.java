package com.platform.exchange.exception;

public enum ErrorMessage {

    USER_NOT_FOUND("The user could not be found!"),
    EXISTING_USER("An account was already created for this email!");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
