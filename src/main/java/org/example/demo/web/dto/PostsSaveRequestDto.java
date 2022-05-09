package org.example.demo.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.demo.domain.posts.Posts;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private Integer meme_kind;
    private Integer category;
    private String title;
    private String explain;
    private String image;
    private String example;
    private String keyw;
    private String keyww;
    private String keywww;

    @Builder
    public PostsSaveRequestDto(Integer meme_kind, Integer category, String title, String image, String explain, String example, String keyw, String keyww, String keywww) {
        this.meme_kind = meme_kind;
        this.category = category;
        this.title = title;
        this.image = image;
        this.explain = explain;
        this.example = example;
        this.keyw = keyw;
        this.keyww = keyww;
        this.keywww = keywww;
    }

    public Posts toEntity() {
        return Posts.builder()
                .meme_kind(this.meme_kind)
                .category(this.category)
                .title(this.title)
                .image(this.image)
                .explain(this.explain)
                .example(this.example)
                .keyw(this.keyw)
                .keyww(this.keyww)
                .keywww(this.keywww)
                .build();
    }
}

