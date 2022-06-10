package org.example.demo.web.dto.posts;

import lombok.Getter;

@Getter
public class PostsListResponseDto {
    private Integer id;
    private String title;
    private String image;
    public PostsListResponseDto(Integer id,String title,String image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }
}