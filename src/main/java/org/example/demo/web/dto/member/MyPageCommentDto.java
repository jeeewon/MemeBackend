package org.example.demo.web.dto.member;

import org.example.demo.domain.comment.Comment;

import java.time.LocalDateTime;

public class MyPageCommentDto {
    String title;
    String content;
    LocalDateTime created_date;

    public MyPageCommentDto(String title,String content,LocalDateTime created_date) {
        this.title = title;
        this.content = content;
        this.created_date = created_date;
    }
}
