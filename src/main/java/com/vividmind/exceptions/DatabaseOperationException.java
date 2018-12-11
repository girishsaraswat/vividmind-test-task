package com.vividmind.exceptions;

/**
 * @author Girish Sarashwat
 */
public class DatabaseOperationException extends RecoverableVividmindException {
    public DatabaseOperationException() {
    }

    public DatabaseOperationException(String message) {
        super(message);
    }

    public DatabaseOperationException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public DatabaseOperationException(Throwable throwable) {
        super(throwable);
    }
}
