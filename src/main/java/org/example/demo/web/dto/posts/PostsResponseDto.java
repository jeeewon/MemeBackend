package org.example.demo.web.dto.posts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.demo.domain.posts.Posts;

import java.util.List;
import java.util.stream.Collectors;
//import org.example.demo.domain.posts.PostsCategory;
//import org.example.demo.domain.posts.PostsCategory;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostsResponseDto {
    private Integer id;
    private String title;
    //private Long fileId;
    private String image;
    private String description;
    private String example;
    private String keyw;
    private String keyww;
    private String keywww;
    private Integer likes;
    private Integer report;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        //this.fileId = entity.getFileId();
        this.image = entity.getImage();
        this.description = entity.getDescription();
        this.example = entity.getExample();
        this.keyw = entity.getKeyw();
        this.keyww = entity.getKeyww();
        this.keywww = entity.getKeywww();
        this.likes = entity.getLikes();
        this.report = entity.getReport();
        //this.comments = entity.getComments().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }
}