package com.bookdelivery.BookDelivery.service;

import com.bookdelivery.BookDelivery.dto.OrderDto;
import com.bookdelivery.BookDelivery.payload.request.order.OrderCreateRequest;

public interface OrderSaveService {

    OrderDto createOrder(OrderCreateRequest orderCreateRequest);
}
