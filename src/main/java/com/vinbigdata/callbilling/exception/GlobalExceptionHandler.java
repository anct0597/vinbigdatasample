package com.vinbigdata.callbilling.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vinbigdata.callbilling.model.response.CommonErrorCode;
import com.vinbigdata.callbilling.model.response.ErrorCode;
import com.vinbigdata.callbilling.model.response.ErrorCodeException;
import com.vinbigdata.callbilling.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
