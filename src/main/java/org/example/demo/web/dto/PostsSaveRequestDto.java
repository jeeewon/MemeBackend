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
    private Integer meme_kind;
    private Integer cate_seq;
    private String title;
    private String explain;
    private String image;
    private String example;
    private String keyw;
    private String keyww;
    private String keywww;

    @Builder
    public PostsSaveRequestDto(Integer meme_kind, Integer cate_seq, String title, String image, String explain, String example, String keyw, String keyww, String keywww) {
        this.meme_kind = meme_kind;
        this.cate_seq = cate_seq;
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
                .cate_seq(this.cate_seq)
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

