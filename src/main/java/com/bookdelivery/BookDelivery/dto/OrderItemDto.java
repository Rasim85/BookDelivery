package com.bookdelivery.BookDelivery.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@EqualsAndHashCode
public class OrderItemDto {

    private Long id;
    private OrderItemBook book;

    @Getter
    @Builder
    @EqualsAndHashCode
    public static class OrderItemBook {

        private String id;
        private String isbn;
        private String name;
        private String authorFullName;
        private BigDecimal price;


    }

}
