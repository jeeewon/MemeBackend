package org.example.demo.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
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
    public PostsUpdateRequestDto(Integer meme_kind, Integer category, String title, String image, String explain, String example, String keyw, String keyww, String keywww) {
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
}
