package com.vinbigdata.callbilling.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public abstract class BaseController {
    private static final Logger log = LoggerFactory.getLogger(BaseController.class);

    public BaseController() {
    }

    protected <T> ResponseEntity<T> toResponseEntity(Optional<T> optional) {
        return !optional.isPresent() ? new ResponseEntity(HttpStatus.NOT_FOUND) : this.toResponseEntity(optional.get());
    }

    protected <T> ResponseEntity<T> toResponseEntity(T data) {
        return new ResponseEntity(data, HttpStatus.OK);
    }

    protected <T> ResponseEntity<T> toResponseEntity(T data, HttpStatus status) {
        return new ResponseEntity(data, status);
    }

    protected <T> ResponseEntity toResponseEntity(Optional<T> optional, HttpStatus status) {
        return (ResponseEntity)optional.map((t) -> {
            return new ResponseEntity(t, status);
        }).orElseGet(() -> {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        });
    }

    protected <T> ResponseEntity<T> toNoBodyContentResponse() {
        return ResponseEntity.noContent().build();
    }

    protected ResponseEntity<String> toOKResponse() {
        return new ResponseEntity("{\"status\": \"OK\"}", HttpStatus.OK);
    }
}