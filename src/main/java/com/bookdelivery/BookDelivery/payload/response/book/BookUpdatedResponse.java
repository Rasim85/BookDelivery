package com.bookdelivery.BookDelivery.payload.response.book;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdatedResponse {
    private String id;
    private String isbn;
    private String name;
    private String authorName;
    private Integer stock;
    private BigDecimal price;
}
