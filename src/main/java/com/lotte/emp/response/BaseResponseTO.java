package com.lotte.emp.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponseTO<T> {
    private boolean status;
    private String message;
    private T data;

    public BaseResponseTO(boolean status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    @JsonCreator
    public static <T> BaseResponseTO<T> of(boolean status, String message, T data) {
        return new BaseResponseTO<>(status, message, data);
    }
}
