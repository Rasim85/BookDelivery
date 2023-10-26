package com.bookdelivery.BookDelivery.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@EqualsAndHashCode
public class OrderDto {

    private Long id;
    private UserDto user;
    private LocalDateTime createdAt;
    private List<OrderItemDto> orderItems;

}
