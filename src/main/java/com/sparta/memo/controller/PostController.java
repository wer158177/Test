package com.sparta.memo.controller;

import com.sparta.memo.dto.PostRequestDto;
import com.sparta.memo.dto.PostResponseDto;
import com.sparta.memo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 생성
    @PostMapping
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    // 게시글 전체 조회
    @GetMapping
    public List<PostResponseDto> getAllPosts() {
        return postService.getAllPosts();
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        return postService.updatePost(id, requestDto);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }
}
