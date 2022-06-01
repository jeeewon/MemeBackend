package org.example.demo.web.dto.posts;

import lombok.*;
//import org.example.demo.domain.member.UserEntity;
import org.example.demo.domain.member.User;
import org.example.demo.domain.posts.Posts;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostsSaveRequestDto {
    private User user;
    private String type;
    private String category;
    private String title;
    private String description;
    private Integer file_id;
    private String example;
    private String keyw;
    private String keyww;
    private String keywww;

    private Integer likes;

    private Integer bookmark_cnt;

    public Posts toEntity() {
        return Posts.builder()
                .user(this.user)
                .type(this.type)
                .category(this.category)
                .file_id(this.file_id)
                .title(this.title)
                .description(this.description)
                .example(this.example)
                .keyw(this.keyw)
                .keyww(this.keyww)
                .keywww(this.keywww)
                .likes(0)
                .bookmark_cnt(0)
                .build();
    }
}