package com.vinbigdata.callbilling.model.response;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
    HttpStatus status();

    String code();

    String message();
}
