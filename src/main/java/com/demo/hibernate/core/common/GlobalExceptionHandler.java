package com.demo.hibernate.core.common;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {


    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException baseException) {
        return new ResponseEntity<>(new ErrorResponse(baseException.getErrorCode()), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        log.info("Exception occurred {}", exception.getMessage());
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.SERVER_FAILED), HttpStatus.OK);
    }
}
