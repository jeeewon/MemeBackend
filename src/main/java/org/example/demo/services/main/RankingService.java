package org.example.demo.services.main;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.posts.PostsRepository;
import org.example.demo.web.dto.posts.PostsListResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RankingService {
    @Autowired
    private final PostsRepository postsRepository;

    @Transactional(readOnly = true)
    public Page<PostsListResponseDto> ranking(String type, Pageable pagerequest) {
        return postsRepository.ranking(type, pagerequest).map(
                posts -> new PostsListResponseDto(
                        posts.getId(),
                        posts.getTitle(),
                        posts.getImage()
                ));
    }
}
