package org.example.demo.web;

import lombok.RequiredArgsConstructor;
import org.example.demo.services.posts.PostsService;
import org.example.demo.web.dto.PostsSaveRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping({"/api/v1/posts"})
    public long save(@RequestBody PostsSaveRequestDto requestDto) {

        return postsService.save(requestDto);
    }

}

