package com.vividmind.exceptions;

/**
 * @author Girish Sarashwat
 */
public class VividmindException extends RuntimeException{

    public VividmindException() {
    }
    /**
     * @param message : message
     * @implNote Constructor One Parameter Pass
     */
    public VividmindException(String message) {
        super(message);
    }

    /**
     * @param message : message
     * @param throwable : throwable
     * @implNote Two parameter pass constructor
     */
    public VividmindException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * @param throwable : throwable
     * @implNote Constructor pass in Throwable class object
     */
    public VividmindException(Throwable throwable) {
        super(throwable);
    }


}
