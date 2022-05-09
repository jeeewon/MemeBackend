/*package org.example.demo.domain.posts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
public class PostsCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cate_seq;

    @Column
    private Integer meme_kind;

    @Column(unique = true)
    private String name;
/*
    @OneToMany(mappedBy = "category")
    private List<Posts> postsList = new ArrayList<>();
*//*
    @Builder
    public PostsCategory(Integer cate_seq,Integer meme_kind, String name){
        this.cate_seq = cate_seq;
        this.meme_kind = meme_kind;
        this.name = name;
    }

    public void mappingPost(Posts posts){
        this.postsList.add(posts);
    }
}*/
