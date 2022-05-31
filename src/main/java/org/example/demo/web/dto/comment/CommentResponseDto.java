package org.example.demo.web.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.demo.domain.comment.Comment;
import org.example.demo.domain.posts.Posts;

@Getter
public class CommentResponseDto {
    String content;

    public CommentResponseDto(Comment comment) {
        this.content = content;
    }
}
