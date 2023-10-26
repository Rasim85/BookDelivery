package com.bookdelivery.BookDelivery.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class CustomResponse<T> {

    public CustomResponse(T repsonse, HttpStatus status) {
        this.response = response;
        this.status = status;
        this.isSuccess = status.is2xxSuccessful();
    }

    private T response;
    private Boolean isSuccess;
    private HttpStatus status;
    @Builder.Default
    private LocalDateTime time = LocalDateTime.now();

    public static final CustomResponse<Void> SUCCESS = CustomResponse.<Void>builder()
            .isSuccess(true)
            .status(HttpStatus.OK)
            .build();

    public static <E> CustomResponse<E> ok(E response) {
        return CustomResponse.<E>builder()
                .response(response)
                .status(HttpStatus.OK)
                .isSuccess(true)
                .build();
    }

    public static <E> CustomResponse<E> created(E response) {
        return CustomResponse.<E>builder()
                .response(response)
                .isSuccess(true)
                .status(HttpStatus.CREATED)
                .build();
    }

}
