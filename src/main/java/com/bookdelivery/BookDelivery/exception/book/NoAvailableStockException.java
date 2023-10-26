package com.bookdelivery.BookDelivery.exception.book;

import com.bookdelivery.BookDelivery.exception.ProcessException;

public class NoAvailableStockException extends ProcessException {

    private final static String MESSAGE_TEMPLATE =
            "No available stock for the given amount";

    private final static String DEFAULT_MESSAGE =
            "No available stock ";

    public NoAvailableStockException(int amount) {
        super(MESSAGE_TEMPLATE.concat(String.valueOf(amount)));
    }

    public NoAvailableStockException() {
        super(DEFAULT_MESSAGE);
    }
}
