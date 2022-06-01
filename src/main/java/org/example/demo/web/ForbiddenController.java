package org.example.demo.web;

import lombok.RequiredArgsConstructor;
import org.example.demo.services.comment.CommentService;
import org.example.demo.services.forbidden.ForbiddenService;
import org.example.demo.services.posts.PostsService;
import org.example.demo.web.dto.comment.CommentSaveDto;
import org.example.demo.web.dto.forbidden.ForbiddenSaveDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class ForbiddenController {
    private final ForbiddenService forbiddenService;
    private final PostsService postsService;

    @PostMapping("/forbidden")
    public Integer forbiddenSave(@RequestBody ForbiddenSaveDto saveDto) {
        return forbiddenService.forbiddenSave(saveDto);
    }

    @DeleteMapping("/forbidden/{id}")
    public Integer delete(@PathVariable Integer id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/forbidden/exist")
    public ResponseEntity<Boolean> checkForbiddenWord(@RequestParam String word){
        return ResponseEntity.ok(forbiddenService.checkForbiddenWord(word));
    }
}
