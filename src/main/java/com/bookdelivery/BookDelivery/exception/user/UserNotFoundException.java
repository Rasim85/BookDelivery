package com.bookdelivery.BookDelivery.exception.user;

import com.bookdelivery.BookDelivery.exception.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public UserNotFoundException(String email) {
        super(MESSAGE_TEMPLATE.concat(email));

    }

    private static final String DEFAULT_MESSAGE =
            "The specified user is not found .";

    private static final String MESSAGE_TEMPLATE =
            "No user was found with given email.";

}
