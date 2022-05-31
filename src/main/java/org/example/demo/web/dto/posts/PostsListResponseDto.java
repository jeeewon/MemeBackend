package org.example.demo.web.dto.posts;

import lombok.Getter;

@Getter
public class PostsListResponseDto {
    private String title;
    public PostsListResponseDto(String title) {
        this.title = title;
    }
}