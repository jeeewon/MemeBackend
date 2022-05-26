package org.example.demo.web.dto.posts;

import lombok.Getter;

@Getter
public class PostsListResponseDto {

    private String title;

    public PostsListResponseDto(String title/*Posts entity*/) {
        //this.title = entity.getTitle();
        this.title = title;
    }
}