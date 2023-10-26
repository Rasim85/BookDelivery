package com.bookdelivery.BookDelivery.service.impl;

import com.bookdelivery.BookDelivery.dto.BookDto;
import com.bookdelivery.BookDelivery.exception.book.BookNotFoundException;
import com.bookdelivery.BookDelivery.exception.book.NoAvailableStockException;
import com.bookdelivery.BookDelivery.mapper.book.BookMapper;
import com.bookdelivery.BookDelivery.model.Book;
import com.bookdelivery.BookDelivery.payload.request.book.BookCreateRequest;
import com.bookdelivery.BookDelivery.payload.request.book.BookUpdateRequest;
import com.bookdelivery.BookDelivery.payload.request.book.BookUpdateStockRequest;
import com.bookdelivery.BookDelivery.payload.request.pagination.PaginationRequest;
import com.bookdelivery.BookDelivery.repository.BookRepository;
import com.bookdelivery.BookDelivery.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookDto createBook(BookCreateRequest request) {
        final Book bookEntityToBeSaved = BookMapper.mapForSaving(request);
        return BookMapper.toDto(bookRepository.save(bookEntityToBeSaved));
    }

    @Transactional
    @Override
    public BookDto getBookById(final String bookId) {
        Book book = getBookWithId(bookId);
        return BookMapper.toDto(book);
    }

    @Override
    @Transactional
    public BookDto updateBookById(String bookId, BookUpdateRequest request) {
        Book bookEntityForUpdate = getBookWithId(bookId);
        BookMapper.mapForUpdating(bookEntityForUpdate, request);
        return BookMapper.toDto(bookRepository.save(bookEntityForUpdate));
    }

    @Override
    @Transactional
    public BookDto updateStockById(String bookId, BookUpdateStockRequest request) {
        Book bookEntityForStockUpdate = getBookWithId(bookId);
        bookEntityForStockUpdate.setStock(request.getStock());
        return BookMapper.toDto(bookRepository.save(bookEntityForStockUpdate));
    }

    @Override
    public Page<BookDto> getAllBooks(PaginationRequest request) {
        return bookRepository.findAll(request.toPageable())
                .map(BookMapper::toDto);
    }


    private Book getBookWithId(String bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
    }

    @Override
    public boolean isStockAvailable(BookDto bookDto, int amount) {
        if (bookDto.getStock() < amount) {
            throw new NoAvailableStockException(amount);
        } else {
            return true;
        }
    }
}
