package org.example.demo.domain.posts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.example.demo.domain.BaseTimeEntity;
import org.example.demo.domain.bookmark.Bookmark;
import org.example.demo.domain.comment.Comment;
import org.example.demo.domain.member.UserEntity;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity(name="posts")
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserEntity userEntity;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String category;

    @Column(length = 100, nullable = false)
    private String title;

    private Integer file_id;
    //private String image;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(columnDefinition = "TEXT")
    private String example;

    @Column(length = 100, nullable = false)
    private String keyw;

    @Column(length = 100)
    private String keyww;

    @Column(length = 100)
    private String keywww;

    @Column(columnDefinition = "integer default 0")
    private Integer likes;

    @Column(columnDefinition = "integer default 0")
    private Integer bookmark_cnt;

    @Column(columnDefinition = "integer default 0")
    private Integer report;

    @ColumnDefault("Y")
    private String activate;

    @OrderBy("id desc")
    @JsonIgnoreProperties({"posts"})
    @OneToMany(mappedBy = "posts", fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    //@JsonIgnoreProperties({"posts"})
    //@OneToMany(mappedBy = "posts",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    //private List<Bookmark> bookmark;

    public void search(String keyw){
        this.keyw=keyw;
    }
    public void updateLikes(Integer likes){
        this.likes = likes;
    }
    public void updateBookmarkCnt(Integer bookmark_cnt){
        this.bookmark_cnt=bookmark_cnt;
    }
}
