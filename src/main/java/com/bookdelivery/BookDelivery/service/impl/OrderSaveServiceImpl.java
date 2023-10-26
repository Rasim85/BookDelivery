package com.bookdelivery.BookDelivery.service.impl;

import com.bookdelivery.BookDelivery.dto.OrderDto;
import com.bookdelivery.BookDelivery.dto.OrderItemDto;
import com.bookdelivery.BookDelivery.exception.user.UserNotFoundException;
import com.bookdelivery.BookDelivery.mapper.order.OrderItemsMapper;
import com.bookdelivery.BookDelivery.mapper.order.OrderMapper;
import com.bookdelivery.BookDelivery.model.Order;
import com.bookdelivery.BookDelivery.model.User;
import com.bookdelivery.BookDelivery.payload.request.order.OrderCreateRequest;
import com.bookdelivery.BookDelivery.repository.OrderRepository;
import com.bookdelivery.BookDelivery.service.OrderItemService;
import com.bookdelivery.BookDelivery.service.OrderSaveService;
import com.bookdelivery.BookDelivery.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderSaveServiceImpl implements OrderSaveService {

    private OrderItemService orderItemService;
    private OrderRepository orderRepository;
    private UserService userService;

    @Override
    @Transactional
    public OrderDto createOrder(OrderCreateRequest orderCreateRequest) {
        User user = userService.findByEmail(orderCreateRequest.getEmail())
                .orElseThrow(() -> new UserNotFoundException(orderCreateRequest.getEmail()));

        List<OrderItemDto> orderItemDtos = orderCreateRequest
                .getOrderDetailSet()
                .stream()
                .map(orderItemService::createOrderItem)
                .toList();
        Order order = Order.builder()
                .user(user)
                .build();
        order.setOrderItems(OrderItemsMapper.toOrderItem(orderItemDtos));
        return OrderMapper.toOrderDto(order);
    }
}
