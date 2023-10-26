package com.bookdelivery.BookDelivery.payload.response.order;

import com.bookdelivery.BookDelivery.dto.OrderItemDto;
import com.bookdelivery.BookDelivery.dto.UserDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderGetByCustomerResponse {
    private Long id;
    private UserDto user;
    private LocalDateTime createdAt;
    private List<OrderItemDto> orderItems;
}
