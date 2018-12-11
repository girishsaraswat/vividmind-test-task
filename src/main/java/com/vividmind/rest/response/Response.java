package com.vividmind.rest.response;

/**
 * @author Girish Sarashwat
 * @param <T> : t
 */
public class Response<T> {

    protected boolean status;

    protected String message = "";

    protected T data;

    public Response() {
    }

    public Response(boolean status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Response(T data) {
        this.data = data;
        this.status = true;
    }



    public Response(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
