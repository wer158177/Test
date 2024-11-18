package com.sparta.memo.service;

import com.sparta.memo.domain.Post;
import com.sparta.memo.dto.PostRequestDto;
import com.sparta.memo.dto.PostResponseDto;
import com.sparta.memo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 게시글 생성
    public PostResponseDto createPost(PostRequestDto requestDto) {
        String content = requestDto.getContent() != null ? requestDto.getContent() : "";

        Post post = Post.builder()
                .username(requestDto.getUsername())
                .title(requestDto.getTitle())
                .content(content) // 기본값 설정
                .price(requestDto.getPrice())
                .build();

        Post savedPost = postRepository.save(post);
        return convertToResponseDto(savedPost);
    }


    // 모든 게시글 조회
    public List<PostResponseDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    // 게시글 수정
    public PostResponseDto updatePost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다. ID: " + id));

        post.setTitle(requestDto.getTitle());
        post.setContent(requestDto.getContent());
        post.setPrice(requestDto.getPrice());
        post.setUsername(requestDto.getUsername());

        Post updatedPost = postRepository.save(post);
        return convertToResponseDto(updatedPost);
    }

    // 게시글 삭제
    public String deletePost(Long id) {
        postRepository.deleteById(id);
        return "삭제완료";
    }

    // Post -> PostResponseDto 변환
    private PostResponseDto convertToResponseDto(Post post) {
        return PostResponseDto.builder()
                .id(post.getId())
                .username(post.getUsername())
                .title(post.getTitle())
                .content(post.getContent())
                .price(post.getPrice())
                .build();
    }
}
