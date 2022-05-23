package org.example.demo.web;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.posts.Posts;
import org.example.demo.domain.posts.PostsRepository;
import org.example.demo.services.posts.PostsService;
import org.example.demo.web.dto.PostsListResponseDto;
import org.example.demo.web.dto.PostsResponseDto;
import org.example.demo.web.dto.PostsSaveRequestDto;
//import org.example.demo.web.dto.PostsUpdateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;
    @Autowired
    PostsRepository postsRepository;

    //등록하기
    @PostMapping("/posts")
    public Long save(@AuthenticationPrincipal String author, @RequestBody PostsSaveRequestDto requestDto) {
        requestDto.toEntity().setAuthor(author);
        return postsService.save(requestDto);
    }

    //상세페이지
    @GetMapping("/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    //삭제
    @DeleteMapping("/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    //전체보기
    @GetMapping("/posts/list/all")
    public Page<PostsListResponseDto> findAllDesc(@PageableDefault(size=5) Pageable pageable){
        return postsService.findAllDesc(pageable);
    }

    //카테고리별 조회하기
    @GetMapping("/posts/list")
    public Page<PostsListResponseDto> categoryList(@RequestParam String type,@RequestParam String category,@PageableDefault(size=5) Pageable pageable){
        return postsService.categoryList(type,category,pageable);
    }

    //검색
    @GetMapping("/posts/search")
    public Page<PostsListResponseDto> search(String keyw,@PageableDefault(size=5) Pageable pageable ) {
        return postsService.search(keyw,pageable);
    }

    /*
    @GetMapping("/posts/search")
    public List<PostsListResponseDto> searchAll(String keyword){
        return postsService.searchAll(keyword);
    }*/



}

