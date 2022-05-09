package org.example.demo.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
//import org.example.demo.domain.posts.PostsCategory;
//import org.example.demo.domain.posts.PostsCategory;

import javax.persistence.criteria.CriteriaBuilder;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
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
    public PostsUpdateRequestDto(Integer meme_kind, Integer cate_seq, String title, String image, String explain, String example, String keyw, String keyww, String keywww) {
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
}
