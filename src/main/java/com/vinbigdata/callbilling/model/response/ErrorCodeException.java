package com.vinbigdata.callbilling.model.response;

public class ErrorCodeException extends RuntimeException {
    private final transient ErrorCode errorCode;

    public ErrorCodeException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return this.errorCode.message();
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }
}
