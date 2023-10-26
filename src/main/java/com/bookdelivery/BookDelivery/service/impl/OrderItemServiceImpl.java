package com.bookdelivery.BookDelivery.service.impl;

import com.bookdelivery.BookDelivery.dto.BookDto;
import com.bookdelivery.BookDelivery.dto.OrderItemDto;
import com.bookdelivery.BookDelivery.mapper.book.BookMapper;
import com.bookdelivery.BookDelivery.mapper.order.OrderItemsMapper;
import com.bookdelivery.BookDelivery.model.Book;
import com.bookdelivery.BookDelivery.model.OrderItem;
import com.bookdelivery.BookDelivery.payload.request.book.BookUpdateRequest;
import com.bookdelivery.BookDelivery.payload.request.book.BookUpdateStockRequest;
import com.bookdelivery.BookDelivery.payload.request.order.OrderItemRequest;
import com.bookdelivery.BookDelivery.service.BookService;
import com.bookdelivery.BookDelivery.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final BookService bookService;

    @Override
    @Transactional
    public OrderItemDto createOrderItem(OrderItemRequest orderItemRequest) {
        final BookDto bookDto = bookService.getBookById(orderItemRequest.getBookId());
        final Book book = BookMapper.toBook(bookDto);
        bookService.isStockAvailable(bookDto, orderItemRequest.getAmount());
        final OrderItem orderItem = OrderItem.builder()
                .book(book)
                .build();

        BookUpdateStockRequest bookUpdateRequest = BookUpdateStockRequest.builder()
                .stock(bookDto.getStock() - orderItemRequest.getAmount())
                .build();
        bookService.updateStockById(bookDto.getId(), bookUpdateRequest);
        return OrderItemsMapper.toOrderItemDto(orderItem);
    }


}
