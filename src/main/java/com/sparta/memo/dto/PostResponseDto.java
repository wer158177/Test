package com.sparta.memo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponseDto {
    private Long id; // 게시글 ID
    private String username; // 작성자 이름
    private String title; // 게시글 제목
    private String content; // 게시글 내용
    private int price; // 게시글 가격
}
