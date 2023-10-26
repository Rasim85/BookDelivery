package com.bookdelivery.BookDelivery.controller;

import com.bookdelivery.BookDelivery.dto.UserDto;
import com.bookdelivery.BookDelivery.mapper.customer.CustomerMapper;
import com.bookdelivery.BookDelivery.payload.request.customer.CustomerCreateRequest;
import com.bookdelivery.BookDelivery.payload.response.CustomResponse;
import com.bookdelivery.BookDelivery.payload.response.customer.CustomerCreatedResponse;
import com.bookdelivery.BookDelivery.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping()
    public CustomResponse<CustomerCreatedResponse> createCustomer(@RequestBody @Valid CustomerCreateRequest createCustomerRequest) {
        final UserDto createdUserEntity = customerService.createCustomer(createCustomerRequest);
        final CustomerCreatedResponse response = CustomerMapper.toCreatedResponse(createdUserEntity);
        return CustomResponse.created(response);

    }
}
