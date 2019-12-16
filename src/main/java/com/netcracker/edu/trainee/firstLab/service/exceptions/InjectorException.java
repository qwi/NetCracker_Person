package com.netcracker.edu.trainee.firstLab.service.exceptions;

public class InjectorException extends Exception {
    public InjectorException(String errorMessage) {
        super(errorMessage);
    }

    public InjectorException(Throwable cause) {
        super(cause);
    }

    InjectorException(Exception exception) {
        super(exception.getMessage());
    }
}
