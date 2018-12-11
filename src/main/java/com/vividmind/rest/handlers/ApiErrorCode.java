package com.vividmind.rest.handlers;

/**
 * @author Girish Sarashwat
 */
public enum ApiErrorCode {
    USER_NOT_ACCESSS(403),
    INVALID_CREDENTIALS(402);

    private int code;

    private ApiErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
