package com.example.kakaochatdesigin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Integer id;
    private String username;
    private String content;
    private Integer userProfile;
    private String chatDate;
}
