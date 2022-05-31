package org.example.demo.services.comment;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.comment.Comment;
import org.example.demo.domain.comment.CommentRepository;
import org.example.demo.domain.member.UserEntity;
import org.example.demo.domain.member.UserRepository;
import org.example.demo.domain.posts.Posts;
import org.example.demo.domain.posts.PostsRepository;
import org.example.demo.web.dto.comment.CommentResponseDto;
import org.example.demo.web.dto.comment.CommentSaveDto;
import org.example.demo.web.dto.posts.PostsListResponseDto;
import org.example.demo.web.dto.posts.PostsResponseDto;
import org.example.demo.web.dto.posts.PostsSaveRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostsRepository postsRepository;
    private final UserRepository userRepository;
/*
    @Transactional
    public void commentSave(Integer posts_id, Comment comment, String email){
        UserEntity userEntity = userRepository.findByEmail(email);
        Posts posts = postsRepository.findById(posts_id).orElseThrow(() -> new IllegalArgumentException("해당 boardId가 없습니다. id=" + posts_id));
        comment.save(posts,userEntity);
        commentRepository.save(comment);
    }*/
/*
    @Transactional
    public Comment saveComment(String content,Integer post_id, String email){
        Posts posts = postsRepository.findById(post_id).get();
        UserEntity userEntity = userRepository.findByEmail(email);
        Comment comment = Comment.builder()
                .content(content)
                .posts(posts)
                .userEntity(userEntity)
                .build();
        return commentRepository.save(comment);
    }
    *//*
    @Transactional
    public Integer save(Integer post_id,String email, CommentSaveDto saveDto) {
        UserEntity userEntity = userRepository.findByEmail(email);
        saveDto.setUserEntity(userEntity);
        Posts posts = postsRepository.findById(post_id).get();
        saveDto.setPosts(posts);
        return (commentRepository.save(saveDto.toEntity())).getId();
    }*/
    /*@Transactional
    public Page<CommentResponseDto> CommentsList(Integer postId, Pageable pagerequest){
        //return new CommentResponseDto(entity)
        return commentRepository.findByPostId(postId,pagerequest).map(
                comments -> new CommentResponseDto(
                        comments.getContent()
                ));
    }*//*
    @Transactional(readOnly = true)
    public List<CommentResponseDto> commentList(Integer id){
        return commentRepository.findByPostId(id).stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());
    }*/
    @Transactional
    public Integer commentSave(String email,Integer id,CommentSaveDto dto){
        UserEntity userEntity = userRepository.findByEmail(email);
        Posts posts = postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다"+id));
        dto.setUserEntity(userEntity);
        dto.setPosts(posts);

        Comment comment = dto.toEntity();
        commentRepository.save(comment);

        return dto.getId();
    }

    @Transactional
    public void commentDelete(Integer id){

        commentRepository.deleteById(id);
    }
}
