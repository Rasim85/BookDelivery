package com.bookdelivery.BookDelivery.exception;

import org.springframework.http.HttpStatus;

public abstract class NotFoundException extends RuntimeException {

    private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

    protected NotFoundException(String message) {
        super(message);
    }
}
