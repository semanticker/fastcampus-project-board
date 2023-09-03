package kr.semanticker.projectboard.dto.request;

import kr.semanticker.projectboard.dto.ArticleCommentDto;
import kr.semanticker.projectboard.dto.UserAccountDto;

public record ArticleCommentRequest(
        Long articleId,
        Long parentCommnetId,
        String content
) {

    public static ArticleCommentRequest of(Long articleId, String content) {
        return ArticleCommentRequest.of(articleId, null, content);
    }
    public static ArticleCommentRequest of(Long articleId, Long parentCommnetId, String content) {
        return new ArticleCommentRequest(articleId, parentCommnetId, content);
    }

    public ArticleCommentDto toDto(UserAccountDto userAccountDto) {
        return ArticleCommentDto.of(
                articleId,
                userAccountDto,
                parentCommnetId,
                content
        );
    }

}