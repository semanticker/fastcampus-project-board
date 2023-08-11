package kr.semanticker.projectboard.dto.request;

import kr.semanticker.projectboard.dto.ArticleDto;
import kr.semanticker.projectboard.dto.HashtagDto;
import kr.semanticker.projectboard.dto.UserAccountDto;

import java.util.Set;

public record ArticleRequest(
        String title,
        String content
) {

    public static ArticleRequest of(String title, String content) {
        return new ArticleRequest(title, content);
    }

    public ArticleDto toDto(UserAccountDto userAccountDto) {
        return toDto(userAccountDto, null);
    }

    public ArticleDto toDto(UserAccountDto userAccountDto, Set<HashtagDto> hashtagDtos) {

        return ArticleDto.of(
                userAccountDto,
                title,
                content,
                hashtagDtos
        );

    }

}
