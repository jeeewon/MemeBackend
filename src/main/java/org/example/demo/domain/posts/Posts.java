package org.example.demo.domain.posts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.example.demo.domain.BaseTimeEntity;
//import org.example.demo.domain.bookmark.Bookmark;
import org.example.demo.domain.comment.Comment;
import org.example.demo.domain.member.UserEntity;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserEntity userEntity;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String category;

    @Column(length = 100, nullable = false)
    private String title;

    //private Long fileId;
    private String image;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String explain;

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

    private Integer bookmarkCnt;

    @Column()//columnDefinition = 0)
    private Integer report;

    @OneToMany(mappedBy = "posts", fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Comment> comments;
/*
    @JsonIgnoreProperties({"posts"})
    @OneToMany(mappedBy = "posts")
    private List<Bookmark> bookmarkList;
*/
    //게시글 수정 메소드
    public void update(String title, String explain){
        this.title = title;
        this.explain =explain;
    }

    //게시글 검색 메소드
    public void search(String keyw){
        this.keyw=keyw;
    }

    public void updateLikes(Integer likes){
        this.likes = likes;
    }
    public void updateBookmarkCnt(Integer bookmarkCnt){
        this.bookmarkCnt=bookmarkCnt;
    }
}

