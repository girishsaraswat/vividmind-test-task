package com.vividmind.exceptions;

/**
 * @author Girish Sarashwat
 */
public class UnrecoverableVividmindException extends VividmindException{

    public UnrecoverableVividmindException() {
    }

    public UnrecoverableVividmindException(String message) {
        super(message);
    }

    public UnrecoverableVividmindException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public UnrecoverableVividmindException(Throwable throwable) {
        super(throwable);
    }
}
