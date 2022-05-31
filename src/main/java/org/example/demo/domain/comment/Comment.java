package org.example.demo.domain.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.example.demo.domain.member.UserEntity;
import org.example.demo.domain.posts.Posts;
import org.example.demo.web.dto.comment.CommentResponseDto;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 500)
    private String content;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Posts posts;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    /*
    @Builder
    public Comment(String content, Posts posts, UserEntity userEntity){
        this.content= content;
        this.posts = posts;
        this.userEntity = userEntity;
    }*/

}
