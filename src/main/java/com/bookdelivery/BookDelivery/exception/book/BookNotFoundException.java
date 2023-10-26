package com.bookdelivery.BookDelivery.exception.book;

import org.webjars.NotFoundException;

public class BookNotFoundException extends NotFoundException {

    private static final String DEFAULT_MESSAGE =
            "The specified Book is not found !";

    private static final String MESSAGE_TEMPLATE =
            "No Book found with ID: ";

    public BookNotFoundException(String id) {
        super(MESSAGE_TEMPLATE.concat(id));
    }

    public BookNotFoundException() {
        super(DEFAULT_MESSAGE);
    }


}
