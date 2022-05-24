package org.example.demo.web.dto;

import lombok.Getter;
import org.example.demo.domain.posts.Posts;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {

    private String title;

    public PostsListResponseDto(String title/*Posts entity*/) {
        //this.title = entity.getTitle();
        this.title = title;
    }
}