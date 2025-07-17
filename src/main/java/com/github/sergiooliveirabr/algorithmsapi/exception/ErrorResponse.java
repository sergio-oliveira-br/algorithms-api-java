package com.github.sergiooliveirabr.algorithmsapi.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timestamp,
        int Status,
        String error,
        String message,
        String path) {

    public ErrorResponse(HttpStatus httpStatus, String message, String path) {
        this(LocalDateTime.now(), httpStatus.value(), httpStatus.getReasonPhrase(), message, path);
    }
}