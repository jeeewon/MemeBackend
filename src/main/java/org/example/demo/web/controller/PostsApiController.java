package org.example.demo.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.services.posts.S3Uploader;
import org.example.demo.services.posts.PostsService;
import org.example.demo.web.dto.posts.PostsListResponseDto;
import org.example.demo.web.dto.posts.PostsResponseDto;
import org.example.demo.web.dto.posts.PostsSaveRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;
    private final S3Uploader s3Uploader;

    //등록하기
    @PostMapping("/posts")
    public void save(Authentication authentication,@RequestBody PostsSaveRequestDto requestDto){
        postsService.save(authentication.getName(),requestDto);
    }
    @PostMapping("/image")
    public void saveImage(Authentication authentication,@RequestPart(value = "requestDto") PostsSaveRequestDto requestDto,@RequestPart(value = "image") MultipartFile multipartFile) throws IOException{
        String image = s3Uploader.upload(multipartFile,"static");
        postsService.saveImage(authentication.getName(),image,requestDto);
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
    public Page<PostsListResponseDto> categoryList(@RequestParam String type,@RequestParam(value = "category" , required = false) String category,@PageableDefault(size=6) Pageable pageable){
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
