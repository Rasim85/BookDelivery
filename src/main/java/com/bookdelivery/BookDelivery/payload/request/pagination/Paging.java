package com.bookdelivery.BookDelivery.payload.request.pagination;

import org.springframework.data.domain.Pageable;

/*
This interface converting objects to a Pageable for pagination
 */
public interface Paging {
    Pageable toPageable();

}
