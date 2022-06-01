package org.example.demo.domain.bookmark;

import lombok.*;
import org.example.demo.domain.posts.Posts;
import org.example.demo.domain.member.UserEntity;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="post_id")
    private Posts posts;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private UserEntity userEntity;

    @Builder
    public Bookmark(Posts posts, UserEntity userEntity){
        this.posts = posts;
        this.userEntity = userEntity;
    }
}

