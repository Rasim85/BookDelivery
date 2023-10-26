package com.bookdelivery.BookDelivery.service;

import com.bookdelivery.BookDelivery.dto.OrderItemDto;
import com.bookdelivery.BookDelivery.payload.request.order.OrderItemRequest;

public interface OrderItemService {
    OrderItemDto createOrderItem(OrderItemRequest orderItemRequest);
}
