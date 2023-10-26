package com.bookdelivery.BookDelivery.service;

import com.bookdelivery.BookDelivery.dto.UserDto;
import com.bookdelivery.BookDelivery.payload.request.customer.CustomerCreateRequest;
import org.springframework.stereotype.Service;


public interface CustomerService {

    UserDto createCustomer(CustomerCreateRequest customerCreateRequest);
}
