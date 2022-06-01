package org.example.demo.web;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.member.UserRepository;
import org.example.demo.services.member.MyPageService;
import org.example.demo.web.dto.member.MyPageBookmarkDto;
import org.example.demo.web.dto.member.MyPageCommentDto;
import org.example.demo.web.dto.member.MyPagePostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MyPageController {

    private final MyPageService myPageService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/mypage/posts")
    public Page<MyPagePostDto> findPostByUser(@AuthenticationPrincipal String email, @RequestParam String type, @PageableDefault(size=6) Pageable pageable){
        Integer id = userRepository.findByEmail(email).getId();
        return myPageService.findPostByUser(id,type,pageable);
    }

    @GetMapping("/mypage/comment")
    public Page<MyPageCommentDto> findCommentByUser(@AuthenticationPrincipal String email, @PageableDefault(size=6) Pageable pageable){
        Integer id = userRepository.findByEmail(email).getId();
        return myPageService.findCommentByUser(id,pageable);
    }

    @GetMapping("/mypage/bookmark")
    public Page<MyPageBookmarkDto> findBookmarkByUser(@AuthenticationPrincipal String email, @RequestParam String type, @PageableDefault(size=6) Pageable pageable){
        Integer id = userRepository.findByEmail(email).getId();
        return myPageService.findBookmarkByUser(id,pageable);
    }
}
