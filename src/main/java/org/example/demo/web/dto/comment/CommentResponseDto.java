package org.example.demo.web.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.demo.domain.comment.Comment;
import org.example.demo.domain.posts.Posts;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    Integer id;
    String content;
    LocalDateTime created_date;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.created_date = comment.getCreated_date();
    }
}
