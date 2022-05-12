/*package org.example.demo.domain.posts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class PostsCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cate_seq;

    /*@Column
    private Integer meme_kind;
    */
/*    @Column(nullable = false)
    private String branch;
    private String code;
    @Column(unique = true)
    private String name;
*/
/*
    @OneToMany(mappedBy = "category")
    private List<Posts> postsList = new ArrayList<>();
*/
/*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "parent_category_id")
    private PostsCategory parentCategory;

    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
    private List<PostsCategory> subCategory = new ArrayList<>();

    private Integer level;
    */
/*
    @Builder
    public PostsCategory(Integer cate_seq,Integer meme_kind, String name){
        this.cate_seq = cate_seq;
        this.meme_kind = meme_kind;
        this.name = name;
    }*/
/*
    @Builder
    public PostsCategory(String branch,String code,String name,Integer level, PostsCategory parentCategory){
        this.branch = branch;
        this.code = code;
        this.name = name;
        this.level = level;
        this.parentCategory = parentCategory;
    }
/*
    public void mappingPost(Posts posts){
        this.postsList.add(posts);
    }
}*/
