package com.bookdelivery.BookDelivery.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@Builder
public class BookDto {

    private String id;
    private String isbn;
    private String name;
    private String authorName;
    private BigDecimal price;
    private Integer stock;

}
