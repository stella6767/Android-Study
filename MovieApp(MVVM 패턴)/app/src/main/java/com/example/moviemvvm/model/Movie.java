package com.example.moviemvvm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {
    private Long id;
    private String url;
    private String title;
    private Long year;
    private Double rating;
    private Long runtime;
    private String summary;
    private String medium_cover_image;
}
