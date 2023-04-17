package kr.semanticker.projectboard.repository;

import kr.semanticker.projectboard.config.JpaConfig;
import kr.semanticker.projectboard.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(
            @Autowired ArticleRepository articleRepository,
            @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelect_thenWorksFine() {
        // Given

        // When
        List<Article> articles = articleRepository.findAll();

        // Then
        assertThat(articles)
                .isNotNull()
                .hasSize(1000);
    }

    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenInsert_thenWorksFine() {
        // Given
        long previousCount = articleRepository.count();

        Article article = Article.of("new artile", "new Content", "#spring");
        articleRepository.save(article);

        long savedCount = articleRepository.count();

        // Then
        assertThat(savedCount)
                .isEqualTo(1001);
    }
}