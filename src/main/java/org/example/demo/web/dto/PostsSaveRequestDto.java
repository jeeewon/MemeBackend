package org.example.demo.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.demo.domain.posts.Posts;
//import org.example.demo.domain.posts.PostsCategory;
//import org.example.demo.domain.posts.PostsCategory;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String author;
    private String type;
    private String category;
    private String title;
    private String explain;
    private String image;
    private String example;
    private String keyw;
    private String keyww;
    private String keywww;

    @Builder
    public PostsSaveRequestDto(String author, String type, String category, String title, String image, String explain, String example, String keyw, String keyww, String keywww) {
        this.author = author;
        this.type = type;
        this.category = category;
        this.image = image;
        this.title = title;
        this.explain = explain;
        this.example = example;
        this.keyw = keyw;
        this.keyww = keyww;
        this.keywww = keywww;
    }

    public Posts toEntity() {
        return Posts.builder()
                .author(this.author)
                .type(this.type)
                .category(this.category)
                .image(this.image)
                .title(this.title)
                .explain(this.explain)
                .example(this.example)
                .keyw(this.keyw)
                .keyww(this.keyww)
                .keywww(this.keywww)
                .build();
    }
}

