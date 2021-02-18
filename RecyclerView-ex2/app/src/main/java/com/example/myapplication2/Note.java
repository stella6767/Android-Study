package com.example.myapplication2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Note {
    private Integer id;
    private String title;
    private String subtitle;
    private Integer min;
}
