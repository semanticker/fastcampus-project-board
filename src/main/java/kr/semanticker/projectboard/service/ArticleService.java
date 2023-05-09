package kr.semanticker.projectboard.service;

import kr.semanticker.projectboard.domain.type.SearchType;
import kr.semanticker.projectboard.dto.ArticleDto;
import kr.semanticker.projectboard.dto.ArticleUpdateDto;
import kr.semanticker.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public List<ArticleDto> searchArticles(SearchType title, String searchKeyword) {

        return List.of(
        );
    }
    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticlesPage(SearchType title, String searchKeyword) {

        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleDto searchArticle(long l) {
        return null;
    }

    public void saveArticle(ArticleDto dto) {

    }

    public void updateArticle(long articleId, ArticleUpdateDto dto) {
    }

    public void deleteArticle(long articleId) {
    }
}
