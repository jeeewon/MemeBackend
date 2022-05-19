package org.example.demo.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.demo.domain.BaseTimeEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long board_seq;
    //@JoinColumn(nullable = false,referencedColumnName = "m_seq")
    private Integer m_seq;

    /*@Column(nullable = false)
    private Integer meme_kind;
    */
    @Column() //tv:1,영화:2,커뮤니티:3,기타:4
    private Integer cate_seq;

    @Column(length = 100, nullable = false)
    private String title;
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

    @Column()
    private Integer likes;

    @Column()//columnDefinition = 0)
    private Integer report;

    @Builder
    public Posts(/*Integer m_seq,*/Integer meme_kind, Integer cate_seq, String title, String image, String explain, String example, String keyw, String keyww, String keywww,Integer likes,Integer report) {
        //this.board_seq = Board_seq()
        this.m_seq = m_seq;
        //this.meme_kind = meme_kind;
        this.cate_seq = cate_seq;
        this.image = image;
        this.title = title;
        this.explain = explain;
        this.example = example;
        this.keyw = keyw;
        this.keyww = keyww;
        this.keywww = keywww;
        this.likes = likes;
        this.report = report;
    }
    public void update(String title, String explain){
        this.title = title;
        this.explain =explain;
    }
    //search
    public void search(String keyw){
        this.keyw=keyw;
    }
}

