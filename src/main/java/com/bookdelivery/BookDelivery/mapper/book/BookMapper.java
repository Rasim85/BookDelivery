package com.bookdelivery.BookDelivery.mapper.book;

import com.bookdelivery.BookDelivery.dto.BookDto;
import com.bookdelivery.BookDelivery.model.Book;
import com.bookdelivery.BookDelivery.payload.request.book.BookCreateRequest;
import com.bookdelivery.BookDelivery.payload.request.book.BookUpdateRequest;
import com.bookdelivery.BookDelivery.payload.response.book.BookCreatedResponse;
import com.bookdelivery.BookDelivery.payload.response.book.BookGetResponse;
import com.bookdelivery.BookDelivery.payload.response.book.BookUpdatedResponse;
import com.bookdelivery.BookDelivery.payload.response.CustomPageResponse;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;


@UtilityClass
public class BookMapper {
    public static BookCreatedResponse toCreatedResponse(BookDto source) {
        return BookCreatedResponse.builder()
                .stock(source.getStock())
                .price(source.getPrice())
                .name(source.getName())
                .id(source.getId())
                .isbn(source.getIsbn())
                .authorName(source.getAuthorName())
                .build();
    }

    public static Book mapForSaving(BookCreateRequest request) {
        return com.bookdelivery.BookDelivery.model.Book.builder()
                .isbn(request.getIsbn())
                .authorname(request.getAuthorFullName())
                .name(request.getName())
                .stock(request.getStock())
                .price(request.getPrice())
                .build();
    }

    public static BookDto toDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .authorName(book.getAuthorname())
                .price(book.getPrice())
                .isbn(book.getIsbn())
                .stock(book.getStock())
                .build();
    }

    public static BookGetResponse toGetResponse(BookDto bookDto) {
        return BookGetResponse.builder()
                .authorName(bookDto.getAuthorName())
                .id(bookDto.getId())
                .isbn(bookDto.getIsbn())
                .stock(bookDto.getStock())
                .price(bookDto.getPrice())
                .name(bookDto.getName())
                .build();
    }

    public static BookUpdatedResponse toUpdatedResponse(BookDto source) {
        if (source == null) {
            return null;
        }
        return BookUpdatedResponse.builder()
                .id(source.getId())
                .isbn(source.getIsbn())
                .name(source.getName())
                .authorName(source.getAuthorName())
                .stock(source.getStock())
                .price(source.getPrice())
                .build();
    }

    public static void mapForUpdating(Book bookEntityForUpdate, BookUpdateRequest request) {
        bookEntityForUpdate.setIsbn(request.getIsbn());
        bookEntityForUpdate.setName(request.getName());
        bookEntityForUpdate.setAuthorname(request.getAuthorFullName());
        bookEntityForUpdate.setStock(request.getStock());
        bookEntityForUpdate.setPrice(request.getPrice());
    }

    public static CustomPageResponse<BookGetResponse> toGetResponse(Page<BookDto> source) {
        return CustomPageResponse.of(source.map(BookMapper::toGetResponse));
    }

    public static Book toBook(BookDto source) {
        return Book.builder()
                .id(source.getId())
                .name(source.getName())
                .authorname(source.getAuthorName())
                .isbn(source.getIsbn())
                .price(source.getPrice())
                .stock(source.getStock())
                .build();
    }
}
