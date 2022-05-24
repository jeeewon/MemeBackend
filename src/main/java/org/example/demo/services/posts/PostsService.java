package org.example.demo.services.posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.posts.Posts;
import org.example.demo.domain.posts.PostsRepository;
import org.example.demo.web.dto.PostsListResponseDto;
import org.example.demo.web.dto.PostsResponseDto;
import org.example.demo.web.dto.PostsSaveRequestDto;
//import org.example.demo.web.dto.PostsUpdateRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    //private final PostsCategoryRepository postsCategoryRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return (postsRepository.save(requestDto.toEntity())).getId();
    }
/*
    @Transactional
    public Long update(Long board_seq, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(board_seq)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. board_seq="+ board_seq));

        posts.update(requestDto.getTitle(), requestDto.getExplain());

        return board_seq;
    }
*/
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }
/*
    //search
    @Transactional
    public List<PostsListResponseDto> search(String keyw) {
        //List<Posts> postsList = postsRepository.findBykeywContaining(keyw);
        //return postsList;
        return postsRepository.findBykeywContaining(keyw).stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<PostsListResponseDto> categoryList(String type,String category){
        return postsRepository.findByTypeOrCategory(type,category).stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
    //
    @Transactional(readOnly=true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
    */

    @Transactional(readOnly=true)
    public Page<PostsListResponseDto> findAllDesc(Pageable pagerequest) {
        return postsRepository.findAllDesc(pagerequest).map(
                posts -> new PostsListResponseDto(
                        posts.getTitle()
                ));
    }

    @Transactional(readOnly=true)
    public Page<PostsListResponseDto> categoryList(String type, String category,Pageable pagerequest) {
        return postsRepository.findByTypeOrCategory(type,category,pagerequest).map(
                posts -> new PostsListResponseDto(
                        posts.getTitle()
                ));
    }

    @Transactional(readOnly=true)
    public Page<PostsListResponseDto> search(String keyw,Pageable pagerequest) {
        return postsRepository.findBykeywContaining(keyw,pagerequest).map(
                posts -> new PostsListResponseDto(
                        posts.getTitle()
                ));
    }

    //삭제
    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. board_seq=" + id));

        postsRepository.delete(posts);
    }
}

