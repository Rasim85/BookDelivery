package com.bookdelivery.BookDelivery.exception.order;

import com.bookdelivery.BookDelivery.exception.NotFoundException;

public class OrderNotFoundException extends NotFoundException {

    private static final String DEFAULT_MESSAGE =
            "Order not found ! ";

    public OrderNotFoundException(String message) {
        super(message);
    }

    public OrderNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

}
