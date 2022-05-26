package org.example.demo.web.dto.posts;

import lombok.*;
import org.example.demo.domain.member.UserEntity;
import org.example.demo.domain.posts.Posts;
//import org.example.demo.domain.posts.PostsCategory;
//import org.example.demo.domain.posts.PostsCategory;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostsSaveRequestDto {
    private UserEntity userEntity;
    private String type;
    private String category;
    private String title;
    private String explain;
    private Long fileId;
    //private String image;
    private String example;
    private String keyw;
    private String keyww;
    private String keywww;
    private Integer likes;

    public Posts toEntity() {
        return Posts.builder()
                .userEntity(this.userEntity)
                .type(this.type)
                .category(this.category)
                //.image(this.image)
                .fileId(this.fileId)
                .title(this.title)
                .explain(this.explain)
                .example(this.example)
                .keyw(this.keyw)
                .keyww(this.keyww)
                .keywww(this.keywww)
                .likes(0)
                .build();
    }
}

