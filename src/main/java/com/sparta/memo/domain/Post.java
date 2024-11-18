package com.sparta.memo.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 게시글 고유 ID

    @Column(nullable = false, length = 50)
    private String username; // 작성자 이름

    @Column(nullable = false, length = 100)
    private String title; // 게시글 제목

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content= ""; // 기본값을 빈 문자열로 설정

    @Column(nullable = false)
    private int price; // 게시글 가격
}
