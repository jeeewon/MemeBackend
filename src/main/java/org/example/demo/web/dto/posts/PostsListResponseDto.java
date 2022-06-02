package org.example.demo.web.dto.posts;

import lombok.Getter;

@Getter
public class PostsListResponseDto {
    private Integer id;
    private String title;
    public PostsListResponseDto(Integer id,String title) {
        this.id = id;
        this.title = title;
    }
}