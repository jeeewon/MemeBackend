package org.example.demo.web.dto.comment;

import lombok.Data;
import org.example.demo.domain.comment.Comment;
import org.example.demo.domain.member.User;
import org.example.demo.domain.posts.Posts;

import javax.validation.constraints.NotBlank;

@Data
public class CommentSaveDto {
    private Integer id;
    @NotBlank
    private String content;
    //private UserEntity userEntity;
    //private Posts posts;
    private Posts posts;
    private User user;
    public Comment toEntity() {
        Comment comments = Comment.builder()
                .id(this.id)
                .content(this.content)
                //.userEntity(this.userEntity)
                //.posts(this.posts)
                .posts(this.posts)
                .user(this.user)
                .build();
        return comments;
    }
}