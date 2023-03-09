package com.vinbigdata.callbilling.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.vinbigdata.callbilling.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

/**
 * @author an.cantuong
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends BaseController {

    @ExceptionHandler(ErrorCodeException.class)
    public ResponseEntity<ErrorResponse> handleErrorCodeException(ErrorCodeException ex) {
        return toErrorResponse(ex);
    }

    @ExceptionHandler(DecodingException.class)
    public ResponseEntity<ErrorResponse> handleDecodingException(DecodingException ex) {
        return toErrorResponse(CommonErrorCode.JSON_ERROR, ex);
    }

    @ExceptionHandler(JsonMappingException.class)
    public ResponseEntity<ErrorResponse> handleJsonMappingException(JsonMappingException ex) {
        return toErrorResponse(CommonErrorCode.JSON_ERROR, ex);
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<ErrorResponse> handleJsonProcessingException(JsonProcessingException ex) {
        return toErrorResponse(CommonErrorCode.JSON_ERROR, ex);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException ex) {
        return toErrorResponse(CommonErrorCode.NULL_POINTER, ex);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorResponse> handleIOException(IOException ex) {
        return toErrorResponse(ApiErrorCode.IO_EXCEPTION, ex);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNameNotFound(UsernameNotFoundException ex) {
        return toErrorResponse(ApiErrorCode.LOGIN_ERROR, ex);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException ex) {
        return toErrorResponse(ApiErrorCode.ACCESS_DENIED, ex);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgNotValid(MethodArgumentNotValidException ex) {
        var fieldError = ex.getBindingResult().getFieldError();
        var errorCode = CommonErrorCode.INVALID_ARG;
        var message = errorCode.message();
        if (fieldError != null && ObjectUtils.isNullOrEmpty(fieldError.getRejectedValue())) {
            errorCode = CommonErrorCode.MISSING_FIELD;
            message = String.format(errorCode.message(), fieldError.getField());
        }

        var errorResp = new ErrorResponse(RandomStringUtils.randomAlphabetic(5), errorCode.code(), message);
        return toResponseEntity(errorResp, errorCode.status());
    }

    public ResponseEntity<ErrorResponse> toErrorResponse(String id,
                                                         String error,
                                                         String message,
                                                         HttpStatus status) {
        return toResponseEntity(new ErrorResponse(id, error, message), status);
    }

    public ResponseEntity<ErrorResponse> toErrorResponse(String id,
                                                         String error,
                                                         String message,
                                                         JsonNode description,
                                                         HttpStatus status) {
        return toResponseEntity(new ErrorResponse(id, error, message, description), status);
    }

    @SuppressWarnings("all")
    public ResponseEntity<ErrorResponse> toErrorResponse(ErrorCodeException ex) {
        var errorCode = ex.getErrorCode();
        var errorResp = new ErrorResponse(errorCode.code(), errorCode.message());
        return toResponseEntity(errorResp, errorCode.status());
    }

    public ResponseEntity<ErrorResponse> toErrorResponse(ErrorCode errorCode, Throwable ex) {
        var errorResp = new ErrorResponse(errorCode.code(), ex.getMessage());
        return toResponseEntity(errorResp, errorCode.status());
    }
}
