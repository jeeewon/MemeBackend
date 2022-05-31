package org.example.demo.web;

import lombok.RequiredArgsConstructor;
import org.example.demo.services.bookmark.BookmarkService;
import org.example.demo.services.posts.PostsService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BookmarkController {
    private final PostsService postsService;
    private final BookmarkService bookmarkService;

    @PostMapping("/posts/{postId}/bookmark")
    public Integer bookmark(@PathVariable Integer postId, Authentication authentication){
        //bookmarkService.bookmark(postId,authentication.getName());
        postsService.updateBookmarkCnt(postId);
        //bookmarkService.bookmark(postId,authentication.getName());
        return postsService.findById(postId).getBookmark_cnt();
    }

    @DeleteMapping("/posts/{postId}/unBookmark")
    public void unBookmark(@PathVariable Integer postId,Authentication authentication){
        postsService.updateBookmarkCnt(postId);
        bookmarkService.unBookmark(postId,authentication.getName());
    }
}
