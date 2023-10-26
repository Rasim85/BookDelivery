package com.bookdelivery.BookDelivery.service;

import com.bookdelivery.BookDelivery.dto.OrderDto;
import com.bookdelivery.BookDelivery.payload.request.pagination.PaginatedFindAllRequest;
import com.bookdelivery.BookDelivery.payload.request.pagination.PaginationRequest;
import org.springframework.data.domain.Page;

public interface OrderService {

    OrderDto findOrderById(Long orderId);

    Page<OrderDto> findAllOrdersBetweenTwoDates(PaginatedFindAllRequest paginationFindAllRequest);

    Page<OrderDto> findAllOrdersByCustomerId(Long customerId, PaginationRequest paginationRequest);



}
