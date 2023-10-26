package com.bookdelivery.BookDelivery.payload.request.pagination;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginationRequest implements Paging {
    @Min(0)
    private int page;

    @Min(1)
    @Max(50)
    private int size;

    @Override
    public Pageable toPageable() {
        return PageRequest.of(page, size);
    }
}
