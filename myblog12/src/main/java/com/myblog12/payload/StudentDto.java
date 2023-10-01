package com.myblog12.payload;

import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String title;
    private String description;
    private String content;
}
