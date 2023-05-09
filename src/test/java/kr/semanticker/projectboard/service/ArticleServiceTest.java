package kr.semanticker.projectboard.service;

import kr.semanticker.projectboard.domain.Article;
import kr.semanticker.projectboard.domain.type.SearchType;
import kr.semanticker.projectboard.dto.ArticleDto;
import kr.semanticker.projectboard.dto.ArticleUpdateDto;
import kr.semanticker.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.BDDMockito.*;

@DisplayName("비지니스 로직 - 게시글")
@RequiredArgsConstructor
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService sut;

    @Mock private ArticleRepository articleRepository;


    @DisplayName("게시글을 검색하면, 게시글 리스트를 반환한다.")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnsArticleList() {
        // Given
        //SearchParameters param = SearchParameters.of(SearchType.TITLE, "search keyword");

        // When
        List<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword"); // 제목, 본문, ID, 닉네임, 해시태그

        // Then
        assertThat(articles).isNotNull();
        // 검색 건수로 검증
    }


    @DisplayName("게시글을 검색하면, 게시글 페이지를 반환한다.")
    @Test
    void givenSearchParameters_whenSearchingArticlesPage_thenReturnsArticleList() {
        // Given
        //SearchParameters param = SearchParameters.of(SearchType.TITLE, "search keyword");

        // When
        Page<ArticleDto> articles = sut.searchArticlesPage(SearchType.TITLE, "search keyword"); // 제목, 본문, ID, 닉네임, 해시태그

        // Then
        assertThat(articles).isNotNull();
        // 검색 건수로 검증
    }

    @DisplayName("게시글을 조회하면, 게시글을 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticle_thenReturnsArticle() {
        // Given
        //SearchParameters param = SearchParameters.of(SearchType.TITLE, "search keyword");

        // When
        ArticleDto article = sut.searchArticle(1L); // 제목, 본문, ID, 닉네임, 해시태그

        // Then
        assertThat(article).isNotNull();
    }

    @DisplayName("게시글 정보를 입력하면, 게시글을 생성한다")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSavesArticle() {
        // Given
        ArticleDto dto = ArticleDto.of(
                LocalDateTime.now(),
                "semanticker",
                "title",
                "content",
                "hashtag"
        );

        // 리턴값이 있는 경우
        //willDoNothing().given(articleRepository.save(any(Article.class)));

        // 리턴값이 있는 경우
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // When
        sut.saveArticle(dto);

        // Then
        then(articleRepository).should().save(any(Article.class));

    }

    @DisplayName("게시글 ID와 수정정보를 입력하면, 게시글을 생성한다")
    @Test
    void givenArticleIdAndInfo_whenUpdatingArticle_thenUpdatesArticle() {
        // Given
        ArticleUpdateDto dto = ArticleUpdateDto.of(
                "title",
                "content",
                "#java"
        );

        // 리턴값이 있는 경우
        //willDoNothing().given(articleRepository.save(any(Article.class)));

        // 리턴값이 있는 경우
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // When
        sut.updateArticle(1L, dto);

        // Then
        then(articleRepository).should().save(any(Article.class));

    }


    @DisplayName("게시글 ID를 입력하면, 게시글을 삭제한다")
    @Test
    void givenArticleId_whenDeletingArticle_thenDeletesArticle() {
        // Given
        ArticleUpdateDto dto = ArticleUpdateDto.of(
                "title",
                "content",
                "#java"
        );

        // 리턴값이 있는 경우
        //willDoNothing().given(articleRepository.save(any(Article.class)));

        // 리턴값이 있는 경우
        BDDMockito.willDoNothing().given(articleRepository).delete(any(Article.class));

        // When
        sut.deleteArticle(1L);

        // Then
        then(articleRepository).should().delete(any(Article.class));

    }



}