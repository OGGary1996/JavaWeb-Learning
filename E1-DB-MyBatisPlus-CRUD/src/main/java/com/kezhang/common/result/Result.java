package com.kezhang.common.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> success(T data){
        return Result.<T>builder()
                .code(1)
                .message("Success")
                .data(data)
                .build();
    }

    public static Result<?> error(Integer code,String message){
        return Result.builder()
                .code(code)
                .message(message)
                .data(null)
                .build();
    }
}
