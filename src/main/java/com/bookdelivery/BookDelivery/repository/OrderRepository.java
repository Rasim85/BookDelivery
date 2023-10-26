package com.bookdelivery.BookDelivery.repository;

import com.bookdelivery.BookDelivery.model.Order;
import com.bookdelivery.BookDelivery.payload.request.pagination.PaginationRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;

public interface OrderRepository extends JpaRepository<Order, Long> , JpaSpecificationExecutor<Order> {
    Page<Order> findAllByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate, Pageable orderPageable);


    Page<Order> findAllByUserId(Long uderId , Pageable pageable);


}
