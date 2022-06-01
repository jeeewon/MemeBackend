package org.example.demo.services.comment;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.comment.Comment;
import org.example.demo.domain.comment.CommentRepository;
import org.example.demo.domain.member.UserEntity;
import org.example.demo.domain.member.UserRepository;
import org.example.demo.domain.posts.Posts;
import org.example.demo.domain.posts.PostsRepository;
import org.example.demo.web.dto.comment.CommentSaveDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostsRepository postsRepository;
    private final UserRepository userRepository;

    @Transactional
    public Integer commentSave(Integer post_id,String email,CommentSaveDto dto){
        UserEntity userEntity = userRepository.findByEmail(email);
        Posts posts = postsRepository.findById(post_id).orElseThrow(()->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다"+post_id));
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
