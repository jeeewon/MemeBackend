package org.example.demo.web;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.posts.PostsRepository;
import org.example.demo.services.bookmark.BookmarkService;
import org.example.demo.services.posts.PostsService;
//import org.example.demo.web.dto.PostsUpdateRequestDto;
import org.example.demo.web.dto.posts.PostsListResponseDto;
import org.example.demo.web.dto.posts.PostsResponseDto;
import org.example.demo.web.dto.posts.PostsSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;
    private final BookmarkService bookmarkService;

    @Autowired
    PostsRepository postsRepository;

    //등록하기
    @PostMapping("/posts")
    public Integer save(@AuthenticationPrincipal String email,@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(email,requestDto);
    }

    //상세페이지
    @GetMapping("/posts/{id}")
    public PostsResponseDto findById(@PathVariable Integer id){
        return postsService.findById(id);
    }

    //삭제
    @DeleteMapping("/posts/{id}")
    public Integer delete(@PathVariable Integer id) {
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
    public Page<PostsListResponseDto> search(String keyw,@RequestParam String type,@PageableDefault(size=5) Pageable pageable ) {
        return postsService.search(keyw,type,pageable);
    }

    @PostMapping("/posts/{id}/likes")
    public void likesUpdate(@PathVariable Integer id){
        postsService.updateLikes(id);
    }

/*
    @PostMapping("/posts/{post_id}/comments")
    public Long commentSave(@AuthenticationPrincipal String email,@PathVariable Long post_id, @RequestParam CommentRequestDto requestDto){
        return commentService.commentSave(email,post_id,requestDto); //id는 board post_id
    }
*/
    @PostMapping("/posts/{post_id}/bookmark")
    public void bookmark(@PathVariable Integer post_id, Authentication authentication){
        //bookmarkService.bookmark(postId,authentication.getName());
        bookmarkService.bookmark(post_id,authentication.getName());
        postsService.updateBookmarkCnt(post_id);
    }

    @DeleteMapping("/posts/{post_id}/unBookmark")
    public void unBookmark(@PathVariable Integer post_id,Authentication authentication){
        bookmarkService.unBookmark(post_id,authentication.getName());
    }

}
