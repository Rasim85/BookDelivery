package com.bookdelivery.BookDelivery.service.impl;

import com.bookdelivery.BookDelivery.dto.UserDto;
import com.bookdelivery.BookDelivery.exception.user.EmailAlreadyExistsException;
import com.bookdelivery.BookDelivery.mapper.user.UserMapper;
import com.bookdelivery.BookDelivery.model.User;
import com.bookdelivery.BookDelivery.payload.request.customer.CustomerCreateRequest;
import com.bookdelivery.BookDelivery.repository.UserRepository;
import com.bookdelivery.BookDelivery.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final UserRepository userRepository;

    /* todo   solve password encoder problem */
    //  private final PasswordEncoderConfig passwordEncoder;

    @Override
    public UserDto createCustomer(CustomerCreateRequest customerCreateRequest) {
        if (userRepository.existsByEmail(customerCreateRequest.getEmail())) {
            throw new EmailAlreadyExistsException(customerCreateRequest.getEmail());
        }
        User user = User.builder()
                .email(customerCreateRequest.getEmail())
                .fullName(customerCreateRequest.getFullName())
                .username(customerCreateRequest.getUsername())
                .password(customerCreateRequest.getPassword())
                .build();
        return UserMapper.toDto(userRepository.save(user));
    }
}
