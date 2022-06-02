package org.example.demo.domain.bookmark;

import lombok.*;
import org.example.demo.domain.posts.Posts;
import org.example.demo.domain.member.UserEntity;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="post_id")
    private Posts posts;

    private String type;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private UserEntity userEntity;

    @ColumnDefault("Y")
    private String activate;
}

