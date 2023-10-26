package com.bookdelivery.BookDelivery.mapper.customer;

import com.bookdelivery.BookDelivery.dto.UserDto;
import com.bookdelivery.BookDelivery.payload.response.customer.CustomerCreatedResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerMapper {

    public static CustomerCreatedResponse toCreatedResponse(UserDto source) {
        if (source == null) {
            return null;
        }
        return CustomerCreatedResponse.builder()
                .id(source.getId())
                .email(source.getEmail())
                .fullName(source.getFullName())
                .username(source.getUsername())
                .build();
    }
}
