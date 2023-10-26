package com.bookdelivery.BookDelivery.payload.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Builder
public class CustomPageResponse<T> {

    /*
    The list of content elements in the response
     */
    private List<T> content;

    /*
    The current page number
     */
    private Integer pageNumber;

    /*
    The number of elements per page
     */
    private Integer pageSize;

    /*
    The total number of page
     */
    private Integer totalPageCount;

    /*
    The total number of elements across all pages
     */
    private Long totalElementCount;

    public static <T> CustomPageResponse<T> of(Page<T> page) {
        return CustomPageResponse.<T>builder()
                .content(page.getContent())
                .pageNumber(page.getNumber())
                .pageSize(page.getSize())
                .totalPageCount(page.getTotalPages())
                .totalElementCount(page.getTotalElements())
                .build();
    }

}
