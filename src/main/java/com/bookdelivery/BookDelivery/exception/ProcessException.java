package com.bookdelivery.BookDelivery.exception;

import org.springframework.http.HttpStatus;

public abstract class ProcessException extends RuntimeException {
    private static final HttpStatus STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    protected ProcessException(String message) {
        super(message);
    }
}
