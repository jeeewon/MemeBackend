package org.example.demo.web.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demo.domain.comment.Comment;
import org.example.demo.domain.posts.Posts;
import org.example.demo.domain.member.UserEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDto {
    private Long id;
    private String comment;
    private UserEntity userEntity;
    private Posts posts;

    public Comment toEntity() {
        Comment comments = Comment.builder()
                .id(id)
                .comment(comment)
                .userEntity(userEntity)
                .posts(posts)
                .build();

        return comments;
    }
}
