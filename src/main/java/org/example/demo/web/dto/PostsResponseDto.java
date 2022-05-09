package org.example.demo.web.dto;

import lombok.Getter;
import org.example.demo.domain.posts.Posts;
//import org.example.demo.domain.posts.PostsCategory;
//import org.example.demo.domain.posts.PostsCategory;

@Getter
public class PostsResponseDto {
    private Long board_seq;
    private Integer meme_kind;
    private Integer cate_seq;
    private String title;
    private String image;
    private String explain;
    private String example;
    private String keyw;
    private String keyww;
    private String keywww;
    private Integer likes;
    private Integer report;

    public PostsResponseDto(Posts entity){
        this.board_seq = entity.getBoard_seq();
        this.meme_kind = entity.getMeme_kind();
        this.cate_seq = entity.getCate_seq();
        this.title = entity.getTitle();
        this.image = entity.getImage();
        this.explain = entity.getExplain();
        this.example = entity.getExample();
        this.keyw = entity.getKeyw();
        this.keyww = entity.getKeyww();
        this.keywww = entity.getKeywww();
        this.likes = entity.getLikes();
        this.report = entity.getReport();
    }
}
