package kr.semanticker.projectboard.service;

import kr.semanticker.projectboard.domain.type.SearchType;
import kr.semanticker.projectboard.dto.ArticleDto;
import kr.semanticker.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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


}