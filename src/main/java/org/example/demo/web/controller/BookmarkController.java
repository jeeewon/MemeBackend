package org.example.demo.web.controller;

import lombok.RequiredArgsConstructor;
import org.example.demo.services.bookmark.BookmarkService;
import org.example.demo.services.posts.PostsService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BookmarkController {
    private final PostsService postsService;
    private final BookmarkService bookmarkService;

    @PostMapping("/posts/{postId}/bookmark")
    public void bookmark(@PathVariable Integer postId, Authentication authentication){
        postsService.updateBookmarkCnt(postId);
        bookmarkService.bookmark(postId,authentication.getName());
    }
}
