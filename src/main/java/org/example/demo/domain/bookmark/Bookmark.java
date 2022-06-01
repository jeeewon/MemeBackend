package org.example.demo.domain.bookmark;

import lombok.*;
import org.example.demo.domain.posts.Posts;
import org.example.demo.domain.member.User;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id")
    private Posts posts;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    @Builder
    public Bookmark(Posts posts, User user){
        this.posts = posts;
        this.user = user;
    }
}

