package com.bookdelivery.BookDelivery.payload.response.customer;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCreatedResponse {

    private Long id;
    private String fullName;
    private String username;
    private String email;
}
