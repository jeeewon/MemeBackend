package org.example.demo.services.posts;

import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.posts.Posts;
//import org.example.demo.domain.posts.PostsCategory;
//import org.example.demo.domain.posts.PostsCategoryRepository;
//import org.example.demo.domain.posts.PostsCategory;
import org.example.demo.domain.posts.PostsRepository;
//import org.example.demo.web.dto.PostsCategoryDto;
import org.example.demo.web.dto.PostsResponseDto;
import org.example.demo.web.dto.PostsSaveRequestDto;
import org.example.demo.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    //private final PostsCategoryRepository postsCategoryRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return (postsRepository.save(requestDto.toEntity())).getBoard_seq();
    }

    @Transactional
    public Long update(Long board_seq, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(board_seq)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. board_seq="+ board_seq));

        posts.update(requestDto.getTitle(), requestDto.getExplain());

        return board_seq;
    }

    public PostsResponseDto findByBoard_seq (Long board_seq){
        Posts entity = postsRepository.findById(board_seq)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+board_seq));

        return new PostsResponseDto(entity);
    }

    //search
    @Transactional
    public List<Posts> search(String keyw) {
        List<Posts> postsList = postsRepository.findBykeywContaining(keyw);
        return postsList;
    }
/*
    public List<PostsCategory> getPostCategoryList (){
        List<PostsCategory> postsCategories = postsCategoryRepository.findAll();
        return postsCategories;
        //   return (List<PostsCategoryDto>)(Object)postsCategoryRepository.findAll();
    }*/
}

