package org.example.demo.web;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.posts.PostsRepository;
import org.example.demo.services.posts.PostsService;
import org.example.demo.web.dto.posts.PostsListResponseDto;
import org.example.demo.web.dto.posts.PostsResponseDto;
import org.example.demo.web.dto.posts.PostsSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @Autowired
    PostsRepository postsRepository;

    //등록하기
    @PostMapping("/posts")
    public Integer save(Authentication authentication,@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(authentication.getName(),requestDto);
    }

    //상세페이지
    @GetMapping("/posts/{id}")
    public PostsResponseDto findById(@PathVariable Integer id){
        return postsService.findById(id);
    }

    //삭제
    @PostMapping("/posts/delete/{id}")
    public Integer delete(@PathVariable Integer id) {
        return postsService.delete(id);
    }

    //전체보기
    @GetMapping("/posts/list/all")
    public Page<PostsListResponseDto> findAllDesc(@PageableDefault(size=6) Pageable pageable){
        return postsService.findAllDesc(pageable);
    }

    //카테고리별 조회하기
    @GetMapping("/posts/list")
    public Page<PostsListResponseDto> categoryList(@RequestParam String type,@RequestParam String category,@PageableDefault(size=6) Pageable pageable){
        return postsService.categoryList(type,category,pageable);
    }

    //검색
    @GetMapping("/posts/search")
    public Page<PostsListResponseDto> search(String keyw,@RequestParam String type,@PageableDefault(size=6) Pageable pageable ) {
        return postsService.search(keyw,type,pageable);
    }

    @PostMapping("/posts/{id}/likes")
    public void likesUpdate(@PathVariable Integer id){
        postsService.updateLikes(id);
    }

    @PostMapping("/posts/{id}/report")
    public void reportUpdate(@PathVariable Integer id){
        postsService.updateReport(id);
    }
}
