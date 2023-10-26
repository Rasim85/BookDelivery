package com.bookdelivery.BookDelivery.service;

import com.bookdelivery.BookDelivery.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByEmail(String email);

}
