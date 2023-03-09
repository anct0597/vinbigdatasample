package com.vinbigdata.callbilling.model.response;

import org.springframework.http.HttpStatus;

public enum CommonErrorCode implements ErrorCode {
    JSON_ERROR("C001", HttpStatus.INTERNAL_SERVER_ERROR, "Json error!"),
    NULL_POINTER("C002", HttpStatus.INTERNAL_SERVER_ERROR, "Some thing went wrong!"),
    INVALID_ARG("C003", HttpStatus.INTERNAL_SERVER_ERROR, "Invalid value field!"),
    MISSING_FIELD("C004", HttpStatus.INTERNAL_SERVER_ERROR, "Require field %s!");

    private final String code;
    private final HttpStatus status;
    private final String message;


    CommonErrorCode(String code, HttpStatus status, String message) {
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