package org.example.demo.web;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.posts.File;
import org.example.demo.domain.posts.PostsRepository;
import org.example.demo.services.posts.FileService;
import org.example.demo.services.posts.PostsService;
import org.example.demo.util.MD5Generator;
import org.example.demo.web.dto.posts.FileDto;
import org.example.demo.web.dto.posts.PostsListResponseDto;
import org.example.demo.web.dto.posts.PostsResponseDto;
import org.example.demo.web.dto.posts.PostsSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;
    private final FileService fileService;

    @Autowired
    PostsRepository postsRepository;

    //등록하기
    @PostMapping("/posts")
    public Integer save(Authentication authentication,/*@RequestParam("file") MultipartFile file,*/ @RequestBody PostsSaveRequestDto requestDto) {
       /*try {
            String origFilename = file.getOriginalFilename();
            String filename = new MD5Generator(origFilename).toString();
            // 실행되는 위치의 'file' 폴더에 파일저장
            String savePath = System.getProperty("user.dir") + "\\files";
            // 파일이 저장되는 폴더가 없으면 폴더 생성
            /*if (!new File(savePath).exists()) {
                try{
                    new File(savePath).mkdir();
                }
                catch(Exception e){
                    e.getStackTrace();
                }
            }*//*
            String filePath = savePath + "\\" + filename;
            //file.transferTo(new File(filePath));

            FileDto fileDto = new FileDto();
            fileDto.setOriginalFileName(origFilename);
            fileDto.setFileName(filename);
            fileDto.setFilePath(filePath);

            Integer file_id = fileService.saveFile(fileDto);
            requestDto.setFile_id(file_id);
            postsService.save(authentication.getName(),requestDto);
        }catch(Exception e){
            e.printStackTrace();
        }*/
        return postsService.save(authentication.getName(),requestDto);
        //return postsService.findById(id);
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


}
