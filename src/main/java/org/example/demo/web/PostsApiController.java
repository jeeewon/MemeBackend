package org.example.demo.web;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.posts.Posts;
import org.example.demo.services.posts.PostsService;
import org.example.demo.web.dto.PostsResponseDto;
import org.example.demo.web.dto.PostsSaveRequestDto;
import org.example.demo.web.dto.PostsUpdateRequestDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {

        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{board_seq}")
    public Long update(@PathVariable Long board_seq, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(board_seq,requestDto);
    }

    @GetMapping("/api/v1/posts/{board_seq}")
    public PostsResponseDto findByBoard_seq(@PathVariable Long board_seq){
        return postsService.findByBoard_seq(board_seq);
    }

    //search
    @GetMapping("/api/v1/posts/search")
    public List<Posts> search(String keyw, Model model) {
        List<Posts> searchList = postsService.search(keyw);
        model.addAttribute("searchList", searchList);
        return postsService.search(keyw);
    }
}

