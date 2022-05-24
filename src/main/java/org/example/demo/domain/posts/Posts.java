package org.example.demo.domain.posts;

import lombok.*;
import org.example.demo.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(generator="system-uuid")
    //@GenericGenerator(name="system-uuid", strategy = "uuid")
    private Long id;
    private String author;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String category;
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
    public Posts(/*Integer m_seq,*/String author, String type, String category, String title, String image, String explain, String example, String keyw, String keyww, String keywww, Integer likes, Integer report) {
        //this.board_seq = Board_seq()
        this.author = author;
        this.type = type;
        this.category = category;
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
    /*
    public void update(String title, String explain){
        this.title = title;
        this.explain =explain;
    }
    //search
    public void search(String keyw){
        this.keyw=keyw;
    }*/
}

