package com.vividmind.exceptions;

/**
 * @author Girish Sarashwat
 */
public class RecoverableVividmindException extends VividmindException {
    public RecoverableVividmindException() {
    }

    public RecoverableVividmindException(String message) {
        super(message);
    }

    public RecoverableVividmindException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public RecoverableVividmindException(Throwable throwable) {
        super(throwable);
    }
}
