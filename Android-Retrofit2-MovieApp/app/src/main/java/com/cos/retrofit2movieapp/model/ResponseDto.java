package com.cos.retrofit2movieapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDto<T> { //모두 json으로 받기 위해
    private int statusCode;
    private T data;
}
