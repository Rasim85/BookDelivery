package com.bookdelivery.BookDelivery.payload.request.order;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderCreateRequest {

    @Valid
    private Set<OrderItemRequest> orderDetailSet;

    private String email;
}
