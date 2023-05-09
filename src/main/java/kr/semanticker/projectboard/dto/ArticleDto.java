package kr.semanticker.projectboard.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ArticleDto (
        LocalDateTime createdAt, String createdBy, String title, String content, String hashtag
) {
    public static ArticleDto of(LocalDateTime createdAt, String createdBy, String title, String content, String hashtag) {
        return new ArticleDto(createdAt, createdBy, title, content, hashtag);
    }
}

/*
*
private Long id;

    @Setter @Column(nullable = false, length = 255) private String title; // 제목
    @Setter @Column(nullable = false, length = 10000) private String content; // 본문

    @Setter @Column private String hashtag;
    *
* */
