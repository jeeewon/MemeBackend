package org.example.demo.services.posts;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.comment.Comment;
import org.example.demo.domain.comment.CommentRepository;
import org.example.demo.domain.posts.Posts;
import org.example.demo.domain.posts.PostsRepository;
import org.example.demo.domain.member.UserEntity;
import org.example.demo.domain.member.UserRepository;
import org.example.demo.web.dto.comment.CommentRequestDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostsRepository postsRepository;

    @Transactional
    public Long commentSave(String email, Long id, CommentRequestDto dto) {
        UserEntity userEntity = userRepository.findByEmail(email);
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + id));

        dto.setUserEntity(userEntity);
        dto.setPosts(posts);

        Comment comment = dto.toEntity();
        commentRepository.save(comment);

        return dto.getId();
    }
}
