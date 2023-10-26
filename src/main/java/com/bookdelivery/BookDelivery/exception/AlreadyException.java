package com.bookdelivery.BookDelivery.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public abstract class AlreadyException extends RuntimeException {

    public static final HttpStatus STATUS = HttpStatus.CONFLICT;

    protected AlreadyException(String message) {
        super(message);
    }

}
