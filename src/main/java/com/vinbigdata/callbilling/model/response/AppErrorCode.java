package com.vinbigdata.callbilling.model.response;

import org.springframework.http.HttpStatus;

public enum AppErrorCode implements ErrorCode {
    NOT_FOUND_USERNAME("APP001", HttpStatus.BAD_REQUEST, "Not found username");
    private final String code;
    private final HttpStatus status;
    private final String message;

    private AppErrorCode(String code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public HttpStatus status() {
        return this.status;
    }

    public String code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}