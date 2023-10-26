package com.bookdelivery.BookDelivery.payload.request.book;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookUpdateRequest {
    @NotBlank
    @Size(min = 10, max = 13)
    private String isbn;

    @NotBlank
    private String name;

    @NotBlank
    private String authorFullName;

    @Min(value = 0)
    private Integer stock;

    @NotNull
    private BigDecimal price;
}