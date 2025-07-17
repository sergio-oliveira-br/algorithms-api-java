package com.github.sergiooliveirabr.algorithmsapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ErrorResponse createErrorResponse(HttpStatus status,
                                              String message,
                                              WebRequest request) {

        String path = request.getDescription(false).replace("uri=", "");
        return new ErrorResponse(status, message, path);
    }

    @ExceptionHandler(InvalidQuantityException.class)
    public ResponseEntity<ErrorResponse> handleInvalidQuantityException(InvalidQuantityException ex,
                                                                        WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = createErrorResponse(status, ex.getMessage(), request);
        return new ResponseEntity<>(errorResponse, status);
    }
}
