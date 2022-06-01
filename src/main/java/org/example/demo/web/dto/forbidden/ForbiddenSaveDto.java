package org.example.demo.web.dto.forbidden;

import lombok.Data;
import org.example.demo.domain.comment.Comment;
import org.example.demo.domain.forbidden.Forbidden;
import org.example.demo.domain.member.UserEntity;
import org.example.demo.domain.posts.Posts;

import javax.validation.constraints.NotBlank;

@Data
public class ForbiddenSaveDto {
    private Integer id;
    @NotBlank
    private String word;
    public Forbidden toEntity() {
        Forbidden forbidden = Forbidden.builder()
                .id(this.id)
                .word(this.word)
                .build();
        return forbidden;
    }
}