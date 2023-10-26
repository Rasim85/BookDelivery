package com.bookdelivery.BookDelivery.controller;

import com.bookdelivery.BookDelivery.dto.OrderDto;
import com.bookdelivery.BookDelivery.mapper.order.OrderMapper;
import com.bookdelivery.BookDelivery.model.Order;
import com.bookdelivery.BookDelivery.payload.request.order.OrderCreateRequest;
import com.bookdelivery.BookDelivery.payload.request.pagination.PaginatedFindAllRequest;
import com.bookdelivery.BookDelivery.payload.request.pagination.PaginationRequest;
import com.bookdelivery.BookDelivery.payload.response.CustomPageResponse;
import com.bookdelivery.BookDelivery.payload.response.CustomResponse;
import com.bookdelivery.BookDelivery.payload.response.order.OrderCreateResponse;
import com.bookdelivery.BookDelivery.payload.response.order.OrderGetBetweenDatesResponse;
import com.bookdelivery.BookDelivery.payload.response.order.OrderGetByCustomerResponse;
import com.bookdelivery.BookDelivery.payload.response.order.OrderGetResponse;
import com.bookdelivery.BookDelivery.service.OrderItemService;
import com.bookdelivery.BookDelivery.service.OrderSaveService;
import com.bookdelivery.BookDelivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderSaveService orderSaveService;
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomResponse<OrderCreateResponse> createOrder(OrderCreateRequest orderCreateRequest) {
        final OrderDto createdOrderEntity = orderSaveService.createOrder(orderCreateRequest);
        final OrderCreateResponse response = OrderMapper.toCreatedResponse(createdOrderEntity);
        return CustomResponse.created(response);
    }

    @GetMapping("/{orderId}")
    public CustomResponse<OrderGetResponse> getOrderById(@PathVariable Long orderId) {
        final OrderDto orderDto = orderService.findOrderById(orderId);
        final OrderGetResponse getResponse = OrderMapper.toGetResponse(orderDto);
        return CustomResponse.ok(getResponse);
    }

    @PostMapping("/between-dates")
    public CustomResponse<CustomPageResponse<OrderGetBetweenDatesResponse>> getOrdersBetweenTwoDates(
            @RequestBody PaginatedFindAllRequest paginationFindAllRequest
    ) {
        final Page<OrderDto> pageOrderDtos = orderService.findAllOrdersBetweenTwoDates(paginationFindAllRequest);
        final CustomPageResponse<OrderGetBetweenDatesResponse> responses = OrderMapper.toGetBetweenDatesResponses(pageOrderDtos);
        return CustomResponse.ok(responses);
    }

    @GetMapping("/customer/{customerId}")
    public CustomResponse<CustomPageResponse<OrderGetByCustomerResponse>> getOrdersByCustomerId(
            @PathVariable Long customerId
            , @RequestBody PaginationRequest paginationRequest
    ) {
        final Page<OrderDto> pageOrderDto =
                orderService.findAllOrdersByCustomerId(customerId, paginationRequest);
        final CustomPageResponse<OrderGetByCustomerResponse> response = OrderMapper
                .toOrderGetByCustomerResponses(pageOrderDto);
        return CustomResponse.ok(response);
    }

}
