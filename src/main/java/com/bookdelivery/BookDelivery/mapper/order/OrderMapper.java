package com.bookdelivery.BookDelivery.mapper.order;

import com.bookdelivery.BookDelivery.dto.OrderDto;
import com.bookdelivery.BookDelivery.mapper.user.UserMapper;
import com.bookdelivery.BookDelivery.model.Order;
import com.bookdelivery.BookDelivery.payload.response.CustomPageResponse;
import com.bookdelivery.BookDelivery.payload.response.order.OrderCreateResponse;
import com.bookdelivery.BookDelivery.payload.response.order.OrderGetBetweenDatesResponse;
import com.bookdelivery.BookDelivery.payload.response.order.OrderGetByCustomerResponse;
import com.bookdelivery.BookDelivery.payload.response.order.OrderGetResponse;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;

@UtilityClass
public class OrderMapper {

    public static OrderDto toOrderDto(Order source) {
        return OrderDto.builder()
                .id(source.getId())
                .user(UserMapper.toDto(source.getUser()))
                .orderItems(OrderItemsMapper.toDto(source.getOrderItems()))
                .build();
    }


    public static OrderCreateResponse toCreatedResponse(OrderDto orderDto) {
        return OrderCreateResponse.builder()
                .id(orderDto.getId())
                .orderItems(orderDto.getOrderItems())
                .user(orderDto.getUser())
                .createdAt(orderDto.getCreatedAt())
                .build();
    }


    public static OrderGetResponse toGetResponse(OrderDto source) {
        return OrderGetResponse.builder()
                .id(source.getId())
                .user(source.getUser())
                .createdAt(source.getCreatedAt())
                .orderItems(source.getOrderItems())
                .build();
    }

    public static OrderGetBetweenDatesResponse toGetBetweenDatesResponse(OrderDto source) {
        return OrderGetBetweenDatesResponse.builder()
                .id(source.getId())
                .createdAt(source.getCreatedAt())
                .orderItems(source.getOrderItems())
                .user(source.getUser())
                .build();
    }

    public static CustomPageResponse<OrderGetBetweenDatesResponse> toGetBetweenDatesResponses(Page<OrderDto> orderDtos) {
        return CustomPageResponse.of(orderDtos.map(OrderMapper::toGetBetweenDatesResponse));
    }

    public static CustomPageResponse<OrderGetByCustomerResponse> toOrderGetByCustomerResponses(Page<OrderDto> orderDtos) {
        return CustomPageResponse.of(orderDtos.map(OrderMapper::toOrderGetByCustomerResponse));
    }

    public static OrderGetByCustomerResponse toOrderGetByCustomerResponse(OrderDto source) {
        return OrderGetByCustomerResponse.builder()
                .orderItems(source.getOrderItems())
                .createdAt(source.getCreatedAt())
                .id(source.getId())
                .user(source.getUser())
                .build();
    }
}
