package kr.semanticker.projectboard.service;

import kr.semanticker.projectboard.domain.Article;
import kr.semanticker.projectboard.domain.ArticleComment;
import kr.semanticker.projectboard.dto.ArticleCommentDto;
import kr.semanticker.projectboard.repository.ArticleCommentRepository;
import kr.semanticker.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.*;

@DisplayName("비지니스 로직 - 댓글")
@RequiredArgsConstructor
@ExtendWith(MockitoExtension.class)
public class ArticleCommentServiceTest {
    @InjectMocks private ArticleCommentService sut;
    @Mock private ArticleRepository articleRepository;
    @Mock private ArticleCommentRepository articleCommentRepository;

    @DisplayName("게시글 아이디로 조회하면 해당하 댓글 리스트를 반환한다.")
    @Test
    void givenArticleId_whenSearchArticleComments_thenReturnArticleComments() {
        // Given
        Long articleId = 1L;
        Article ar = Article.of("title", "content", "#java");
        BDDMockito.given(articleRepository.findById(articleId)).willReturn(
                Optional.of(ar)
        );
        // When
        List<ArticleCommentDto> articleComments = sut.searchArticleComment(1L);

        // Then
        assertThat(articleComments).isNotNull();
        BDDMockito.then(articleRepository).should().findById(articleId);

    }

    @DisplayName("댓글 정보를 입력하면, 댓글을 저장한다.")
    @Test
    void givenArticleCommentInfo_whenSavingArticleComment_thenSavesArticleComment() {
        // Given
        BDDMockito.given(articleCommentRepository.save(any(ArticleComment.class))).willReturn(null);

        // When
        sut.saveArticleComment(ArticleCommentDto.of(LocalDateTime.now(), "Uno", LocalDateTime.now(), "Uno", "comment"));

        // Then
        BDDMockito.then(articleCommentRepository).should().save(any(ArticleComment.class));
    }
}
