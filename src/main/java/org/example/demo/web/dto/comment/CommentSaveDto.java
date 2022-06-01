package org.example.demo.web.dto.comment;

import lombok.Data;
import org.example.demo.domain.comment.Comment;
import org.example.demo.domain.member.UserEntity;
import org.example.demo.domain.posts.Posts;

import javax.validation.constraints.NotBlank;

@Data
public class CommentSaveDto {
    private Integer id;
    @NotBlank
    private String content;
    private Posts posts;
    private UserEntity userEntity;
    public Comment toEntity() {
        Comment comments = Comment.builder()
                .id(this.id)
                .content(this.content)
                .posts(this.posts)
                .userEntity(this.userEntity)
                .build();
        return comments;
    }
}