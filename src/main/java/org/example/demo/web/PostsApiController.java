package org.example.demo.web;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.posts.PostsRepository;
import org.example.demo.services.posts.PostsService;
//import org.example.demo.web.dto.PostsUpdateRequestDto;
import org.example.demo.web.dto.posts.PostsListResponseDto;
import org.example.demo.web.dto.posts.PostsResponseDto;
import org.example.demo.web.dto.posts.PostsSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @Autowired
    PostsRepository postsRepository;

    //등록하기
    @PostMapping("/posts")
    public Long save(@AuthenticationPrincipal String email, @RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(email,requestDto);
    }

    //상세페이지
    @GetMapping("/posts/{id}")
    public PostsResponseDto findById(@PathVariable/* @RequestParam*/ Long id){
        //postsService.updateLikes(id);
        /*List<CommentResponseDto> comments = postsService.findById(id);
        if(comments!=null&&!comments.isEmpty()) {
            model.addAttribute("comments",comments);
        }*/
        //model.addAttribute("likes", postsService.updateLikes(id));
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

    @PostMapping("/posts/{id}/likes")
    public Integer likesUpdate(@PathVariable Long id){
        return postsService.updateLikes(id);
    }
/*
    @PostMapping("/posts/{id}/comments")
    public Long commentSave(@AuthenticationPrincipal String email,@PathVariable Long id, @RequestParam CommentRequestDto requestDto){
        return commentService.commentSave(email,id,requestDto); //id는 board id
    }
*//*
    @PostMapping("/posts/{postId}/bookmark")
    public void bookmark(@PathVariable Long postId, @AuthenticationPrincipal String email){
        //bookmarkService.bookmark(postId,authentication.getName());
        bookmarkService.bookmark(postId,email);
    }

    @DeleteMapping("/posts/{id}/unBookmark")
    public void unBookmark(@PathVariable Long id,Authentication authentication){
        bookmarkService.unBookmark(id,authentication.getName());
    }
*/
}
