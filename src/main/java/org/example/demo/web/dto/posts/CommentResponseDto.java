package org.example.demo.web.dto.posts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.demo.domain.comment.Comment;

@RequiredArgsConstructor
@Getter
public class CommentResponseDto {

    private Long id;
    private String comment;
    private Long postsId;

    /* Entity -> Dto*/
    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.postsId = comment.getPosts().getId();
    }
}