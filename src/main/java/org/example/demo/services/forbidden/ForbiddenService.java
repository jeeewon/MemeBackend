package org.example.demo.services.forbidden;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.comment.Comment;
import org.example.demo.domain.comment.CommentRepository;
import org.example.demo.domain.forbidden.Forbidden;
import org.example.demo.domain.forbidden.ForbiddenRepository;
import org.example.demo.domain.member.UserEntity;
import org.example.demo.domain.member.UserRepository;
import org.example.demo.domain.posts.Posts;
import org.example.demo.domain.posts.PostsRepository;
import org.example.demo.web.dto.comment.CommentSaveDto;
import org.example.demo.web.dto.forbidden.ForbiddenSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ForbiddenService {
    @Autowired
    private final ForbiddenRepository forbiddenRepository;

    @Transactional
    public Integer forbiddenSave(ForbiddenSaveDto dto){
        Forbidden forbidden = dto.toEntity();
        forbiddenRepository.save(forbidden);

        return dto.getId();
    }
    public boolean checkForbiddenWord(String email){
        return forbiddenRepository.existsByWord(email);
    }

}
