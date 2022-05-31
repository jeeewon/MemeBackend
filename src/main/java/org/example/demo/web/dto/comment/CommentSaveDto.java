package org.example.demo.web.dto.comment;

import lombok.Data;
import org.example.demo.domain.comment.Comment;
import org.example.demo.domain.member.UserEntity;
import org.example.demo.domain.posts.Posts;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CommentSaveDto {
    private Integer id;
    @NotBlank
    private String content;
    private UserEntity userEntity;
    private Posts posts;

    public Comment toEntity() {
        Comment comments = Comment.builder()
                .id(this.id)
                .content(this.content)
                .userEntity(this.userEntity)
                .posts(this.posts)
                .build();
        return comments;
    }
}