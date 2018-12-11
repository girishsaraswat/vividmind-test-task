package com.vividmind.rest.handlers;

import com.vividmind.rest.response.Response;

/**
 * @author Girish Sarashwat
 */
public class ApiErrorResponse extends Response<String> {

    private ApiErrorCode errorCode;

    public ApiErrorResponse(ApiErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ApiErrorResponse(boolean status, String message, String data, ApiErrorCode errorCode) {
        super(status, message, data);
        this.errorCode = errorCode;
    }

    public ApiErrorResponse(String data, ApiErrorCode errorCode) {
        super(data);
        this.errorCode = errorCode;
    }

    public ApiErrorResponse(boolean status, String message, ApiErrorCode errorCode) {
        super(status, message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode.getCode();
    }
}

