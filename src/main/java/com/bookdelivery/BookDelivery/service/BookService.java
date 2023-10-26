package com.bookdelivery.BookDelivery.service;

import com.bookdelivery.BookDelivery.dto.BookDto;
import com.bookdelivery.BookDelivery.payload.request.book.BookCreateRequest;
import com.bookdelivery.BookDelivery.payload.request.book.BookUpdateRequest;
import com.bookdelivery.BookDelivery.payload.request.book.BookUpdateStockRequest;
import com.bookdelivery.BookDelivery.payload.request.pagination.PaginationRequest;
import org.springframework.data.domain.Page;

public interface BookService {
    BookDto createBook(BookCreateRequest request);

    BookDto getBookById(String id);

    BookDto updateBookById(String bookId, BookUpdateRequest request);


    BookDto updateStockById(String bookId, BookUpdateStockRequest request);

    Page<BookDto> getAllBooks (PaginationRequest request);

    boolean isStockAvailable(BookDto bookDto, int amount);
}
