package com.vividmind.exceptions;

/**
 * @author Girish Sarashwat
 */
public class InitializationException extends UnrecoverableVividmindException{

    public InitializationException() {
    }

    public InitializationException(String message) {
        super(message);
    }

    public InitializationException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public InitializationException(Throwable throwable) {
        super(throwable);
    }
}
