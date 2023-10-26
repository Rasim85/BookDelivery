package com.bookdelivery.BookDelivery.mapper.user;

import com.bookdelivery.BookDelivery.dto.UserDto;
import com.bookdelivery.BookDelivery.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

   public  UserDto toDto(User source){
        return UserDto.builder()
                .email(source.getEmail())
                .fullName(source.getFullName())
                .username(source.getFullName())
                .id(source.getId())
                .build();
    }
}
