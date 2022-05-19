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

    @PostMapping("/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {

        return postsService.save(requestDto);
    }

    @PutMapping("/posts/{board_seq}")
    public Long update(@PathVariable Long board_seq, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(board_seq,requestDto);
    }

    @GetMapping("/posts/{board_seq}")
    public PostsResponseDto findByBoard_seq(@PathVariable Long board_seq){
        return postsService.findByBoard_seq(board_seq);
    }

    //search
    @GetMapping("/posts/search")
    public List<Posts> search(String keyw, Model model) {
        List<Posts> searchList = postsService.search(keyw);
        model.addAttribute("searchList", searchList);
        return postsService.search(keyw);
    }
}

