package org.example.demo.web;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.comment.Comment;
import org.example.demo.services.comment.CommentService;
import org.example.demo.web.dto.comment.CommentResponseDto;
import org.example.demo.web.dto.comment.CommentSaveDto;
import org.example.demo.web.dto.posts.PostsResponseDto;
import org.example.demo.web.dto.posts.PostsSaveRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;
/*
    @PostMapping("/posts/{id}/comment")
    public void save(@PathVariable Integer id, @RequestBody CommentSaveDto commentSaveDto, String email){
        commentService.saveComment();
    }*/
    /*
    @PostMapping("/comment")
    public ResponseEntity<?> addComment(@Valid @RequestBody CommentUploadDto commentUploadDto, BindingResult bindingResult, @AuthenticationPrincipal String email) {
        return new ResponseEntity<>(commentService.saveComment(commentUploadDto.getContent(), commentUploadDto.getPost_id(), commentUploadDto.set, HttpStatus.OK);
    }*/
    @PostMapping("/posts/{id}/comment")
    public Integer commentSave(@PathVariable Integer id, @AuthenticationPrincipal String email, @RequestBody CommentSaveDto saveDto) {
        return commentService.commentSave(email,id,saveDto);
    }

    //@GetMapping("/posts/{id}/comment")
    //public Page<CommentResponseDto> getPostComment(@PathVariable Integer id, @PageableDefault(size=5) Pageable pageable){
      //  return commentService.CommentsList(id,pageable);
    //}
}
