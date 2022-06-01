package org.example.demo.web;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.posts.Posts;
import org.example.demo.services.main.RankingService;
import org.example.demo.web.dto.posts.PostsListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/main")
public class MainController {
    private final RankingService rankingService;

    @GetMapping("/ranking")
    public Page<PostsListResponseDto> findAllDesc(@PageableDefault(size=5) Pageable pageable){
        return rankingService.ranking("단어",pageable);
    }
}
