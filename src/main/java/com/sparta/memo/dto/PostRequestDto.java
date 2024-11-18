package com.sparta.memo.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {
    private String username; // 작성자 이름
    private String title; // 게시글 제목
    private String content; // 게시글 내용
    private int price; // 게시글 가격
}
