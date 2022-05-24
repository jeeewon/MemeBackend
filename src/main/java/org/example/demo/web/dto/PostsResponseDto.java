package org.example.demo.web.dto;

import lombok.Getter;
import org.example.demo.domain.posts.Posts;
//import org.example.demo.domain.posts.PostsCategory;
//import org.example.demo.domain.posts.PostsCategory;

@Getter
public class PostsResponseDto {
    private Long id;
    //private String author;
    //private String type;
    //private String cate_seq;
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
        this.id = entity.getId();
        //this.author = entity.getAuthor();
        //this.type = entity.getType();
        //this.cate_seq = entity.getCategory();
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
