package org.example.demo.web;

import lombok.RequiredArgsConstructor;
import org.example.demo.services.comment.CommentService;
import org.example.demo.web.dto.comment.CommentSaveDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/posts/{post_id}/comment")
    public Integer commentSave(@PathVariable Integer post_id, Authentication authentication, @RequestBody CommentSaveDto saveDto) {
        return commentService.commentSave(post_id,authentication.getName(),saveDto);
    }
}
