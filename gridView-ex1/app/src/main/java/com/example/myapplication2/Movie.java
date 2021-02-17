package com.example.myapplication2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {
    private Integer id;
    private String title;
    private Integer pic; //이미지 주소는
    //10개 - (1) 테이블이랑 똑같이 만든다.
}
