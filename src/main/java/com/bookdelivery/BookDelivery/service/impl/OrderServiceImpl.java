package com.bookdelivery.BookDelivery.service.impl;

import com.bookdelivery.BookDelivery.dto.OrderDto;
import com.bookdelivery.BookDelivery.exception.order.OrderNotFoundException;
import com.bookdelivery.BookDelivery.mapper.order.OrderMapper;
import com.bookdelivery.BookDelivery.model.Order;
import com.bookdelivery.BookDelivery.payload.request.pagination.DateIntervalRequest;
import com.bookdelivery.BookDelivery.payload.request.pagination.PaginatedFindAllRequest;
import com.bookdelivery.BookDelivery.payload.request.pagination.PaginationRequest;
import com.bookdelivery.BookDelivery.repository.OrderRepository;
import com.bookdelivery.BookDelivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public OrderDto findOrderById(Long orderId) {
        return OrderMapper.toOrderDto(orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id : " + orderId)));

    }

    @Override
    public Page<OrderDto> findAllOrdersBetweenTwoDates(PaginatedFindAllRequest paginationFindAllRequest) {

        DateIntervalRequest dateIntervalRequest = paginationFindAllRequest.getDateIntervalRequest();
        PaginationRequest paginationRequest = paginationFindAllRequest.getPaginationRequest();

        return orderRepository.findAllByCreatedAtBetween(
                dateIntervalRequest.getStartDate()
                , dateIntervalRequest.getEndDate(),
                paginationRequest.toPageable()
        ).map(OrderMapper::toOrderDto);
    }

    @Override
    public Page<OrderDto> findAllOrdersByCustomerId(Long customerId, PaginationRequest paginationRequest) {
        return orderRepository.findAllByUserId(customerId, paginationRequest.toPageable())
                .map(OrderMapper::toOrderDto);
    }
}
