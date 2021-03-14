package com.sungwook.study.springpracticeboard.service.posts;

import com.sungwook.study.springpracticeboard.domain.posts.Posts;
import com.sungwook.study.springpracticeboard.domain.posts.PostsRepository;
import com.sungwook.study.springpracticeboard.web.dto.PostsResponseDto;
import com.sungwook.study.springpracticeboard.web.dto.PostsSaveRequestDto;
import com.sungwook.study.springpracticeboard.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다." +
                " id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다." +
                " id=" + id));

        return new PostsResponseDto(posts);
    }

}