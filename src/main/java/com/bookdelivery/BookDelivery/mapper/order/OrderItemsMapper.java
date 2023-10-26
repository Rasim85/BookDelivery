package com.bookdelivery.BookDelivery.mapper.order;

import com.bookdelivery.BookDelivery.dto.OrderItemDto;
import com.bookdelivery.BookDelivery.model.Book;
import com.bookdelivery.BookDelivery.model.Order;
import com.bookdelivery.BookDelivery.model.OrderItem;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class OrderItemsMapper {

    public static OrderItem toOrderItem(OrderItemDto source) {
        return OrderItem.builder()
                .id(source.getId())
                .book(toBook(source.getBook()))
                .build();
    }


    public static List<OrderItem> toOrderItem(List<OrderItemDto> orderItemDtos) {
        return orderItemDtos.stream().map(OrderItemsMapper::toOrderItem).toList();
    }

    public OrderItemDto toOrderItemDto(OrderItem orderItem) {
        return OrderItemDto.builder()
                .id(orderItem.getId())
                .book(toBook(orderItem.getBook()))
                .build();
    }

    public List<OrderItemDto> toDto(List<OrderItem> orders) {
        return orders.stream().map(OrderItemsMapper::toOrderItemDto).toList();
    }


    private static Book toBook(OrderItemDto.OrderItemBook orderItemBook) {
        return Book.builder()
                .id(orderItemBook.getId())
                .isbn(orderItemBook.getIsbn())
                .price(orderItemBook.getPrice())
                .name(orderItemBook.getName())
                .authorname(orderItemBook.getAuthorFullName())
                .build();
    }

    private OrderItemDto.OrderItemBook toBook(Book book) {
        return OrderItemDto.OrderItemBook.builder()
                .id(book.getId())
                .name(book.getName())
                .authorFullName(book.getAuthorname())
                .isbn(book.getIsbn())
                .price(book.getPrice())
                .build();
    }
}
