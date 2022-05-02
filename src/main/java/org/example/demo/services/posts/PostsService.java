package org.example.demo.services.posts;

import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.posts.Posts;
import org.example.demo.domain.posts.PostsRepository;
import org.example.demo.web.dto.PostsSaveRequestDto;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto requestDto) {
        return ((Posts)this.postsRepository.save(requestDto.toEntity())).getId();
    }
}

