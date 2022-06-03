package org.example.demo.web.dto.posts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.demo.domain.comment.Comment;
import org.example.demo.domain.posts.Posts;
import org.example.demo.web.dto.comment.CommentResponseDto;

import java.util.List;
import java.util.stream.Collectors;
//import org.example.demo.domain.posts.PostsCategory;
//import org.example.demo.domain.posts.PostsCategory;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostsResponseDto {
    private Integer id;
    private String title;
    private Integer file_id;
    //private String image;
    private String description;
    private String example;
    private String keyw;
    private String keyww;
    private String keywww;
    private Integer likes;

    private Integer bookmark;
    // private Integer bookmark_cnt;
    private Integer report;
    private List<CommentResponseDto> comments;
    public PostsResponseDto(Posts entity,Integer bookmark){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.file_id = entity.getFile_id();
        this.description = entity.getDescription();
        this.example = entity.getExample();
        this.keyw = entity.getKeyw();
        this.keyww = entity.getKeyww();
        this.keywww = entity.getKeywww();
        this.likes = entity.getLikes();
        this.bookmark = bookmark;
        //this.bookmark_cnt = entity.getBookmark_cnt();
        this.report = entity.getReport();
        this.comments = entity.getComments().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }
}