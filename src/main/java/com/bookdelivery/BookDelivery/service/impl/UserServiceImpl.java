package com.bookdelivery.BookDelivery.service.impl;

import com.bookdelivery.BookDelivery.model.User;
import com.bookdelivery.BookDelivery.repository.UserRepository;
import com.bookdelivery.BookDelivery.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
