package com.bookdelivery.BookDelivery.repository;

import com.bookdelivery.BookDelivery.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,String> {
}
