package org.example.demo.web.dto.member;

import lombok.Getter;
import lombok.ToString;
import org.example.demo.domain.comment.Comment;

import java.time.LocalDateTime;

@Getter
public class MyPageCommentDto {
    Integer id;
    String title;
    String content;
    LocalDateTime created_date;

    public MyPageCommentDto(Integer id,String title,String content,LocalDateTime created_date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.created_date = created_date;
    }
     /*
    public MyPageCommentDto(Comment comment){
        this.title = comment.getPosts().getTitle();
        this.content = comment.getContent();
        this.created_date = comment.getCreated_date();
    }*/
}
