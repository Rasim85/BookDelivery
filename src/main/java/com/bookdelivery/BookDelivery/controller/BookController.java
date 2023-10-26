package com.bookdelivery.BookDelivery.controller;

import com.bookdelivery.BookDelivery.dto.BookDto;
import com.bookdelivery.BookDelivery.mapper.book.BookMapper;
import com.bookdelivery.BookDelivery.payload.request.book.BookCreateRequest;
import com.bookdelivery.BookDelivery.payload.request.book.BookUpdateRequest;
import com.bookdelivery.BookDelivery.payload.request.book.BookUpdateStockRequest;
import com.bookdelivery.BookDelivery.payload.request.pagination.PaginationRequest;
import com.bookdelivery.BookDelivery.payload.response.*;
import com.bookdelivery.BookDelivery.payload.response.book.BookCreatedResponse;
import com.bookdelivery.BookDelivery.payload.response.book.BookGetResponse;
import com.bookdelivery.BookDelivery.payload.response.book.BookUpdatedResponse;
import com.bookdelivery.BookDelivery.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CustomResponse<BookCreatedResponse> createBook(@RequestBody @Valid final BookCreateRequest request) {
        final BookDto createdBookEntity = bookService.createBook(request);
        final BookCreatedResponse response = BookMapper.toCreatedResponse(createdBookEntity);
        return CustomResponse.created(response);
    }

    @GetMapping("/{bookId}")
    public CustomResponse<BookGetResponse> getBookById(@PathVariable("bookId") String bookId) {
        final BookDto bookDto = bookService.getBookById(bookId);
        final BookGetResponse response = BookMapper.toGetResponse(bookDto);
        return CustomResponse.ok(response);
    }

    @PutMapping("/{bookId}")
    public CustomResponse<BookUpdatedResponse> updateBookById(@PathVariable String bookId
            , @Valid @RequestBody BookUpdateRequest request) {

        final BookDto updatedBook = bookService.updateBookById(bookId, request);
        final BookUpdatedResponse response = BookMapper.toUpdatedResponse(updatedBook);
        return CustomResponse.ok(response);
    }

    @PutMapping("/stock_amount/{bookId}")
    public CustomResponse<BookUpdatedResponse> updateStock(@PathVariable("bookId") String bookId,
                                                           @RequestBody @Valid final BookUpdateStockRequest request) {
        final BookDto updatedBookEntity = bookService.updateStockById(bookId, request);
        final BookUpdatedResponse response = BookMapper.toUpdatedResponse(updatedBookEntity);
        return CustomResponse.ok(response);
    }

    @PostMapping("/all")
    public CustomResponse<CustomPageResponse<BookGetResponse>> getBooks(@Valid @RequestBody PaginationRequest paginationRequest) {
        final Page<BookDto> bookEntitiesFromDb = bookService.getAllBooks(paginationRequest);
        final CustomPageResponse<BookGetResponse> responses = BookMapper.toGetResponse(bookEntitiesFromDb);
        return CustomResponse.ok(responses);
    }

}
