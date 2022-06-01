package org.example.demo.services.member;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.bookmark.BookmarkRepository;
import org.example.demo.domain.comment.CommentRepository;
import org.example.demo.domain.posts.PostsRepository;
import org.example.demo.web.dto.member.MyPageBookmarkDto;
import org.example.demo.web.dto.member.MyPageCommentDto;
import org.example.demo.web.dto.member.MyPagePostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MyPageService {

    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Transactional(readOnly=true)
    public Page<MyPagePostDto> findPostByUser(Integer id,String type,Pageable pagerequest) {
        return postsRepository.findByUserAndType(id,type,pagerequest).map(
                posts -> new MyPagePostDto(
                        posts.getFile_id(),
                        posts.getTitle(),
                        posts.getDescription()
                )
        );
    }

    @Transactional(readOnly=true)
    public Page<MyPageCommentDto> findCommentByUser(Integer id, Pageable pagerequest) {
        return commentRepository.findByUser(id,pagerequest).map(
                comment -> new MyPageCommentDto(
                        comment.getPosts().getTitle(),
                        comment.getContent(),
                        comment.getCreated_date()
                )
        );
    }

    @Transactional(readOnly=true)
    public Integer findBookmarkByUser(Integer id) {
        return bookmarkRepository.findByUser(id);
                /*
        return bookmarkRepository.findByUser(id,pagerequest).map(
                bookmark -> new MyPageBookmarkDto(
                        bookmark.getPosts().getFile_id(),
                        bookmark.getPosts().getTitle(),
                        bookmark.getPosts().getDescription()
                )
        );*/
    }

}
