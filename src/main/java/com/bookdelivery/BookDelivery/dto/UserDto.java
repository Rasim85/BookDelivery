package com.bookdelivery.BookDelivery.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode
@Builder
public class UserDto {

    private Long id;
    private String username;
    private String email;
    private String fullName;

}
