package kr.semanticker.projectboard.service;

import kr.semanticker.projectboard.dto.ArticleCommentDto;
import kr.semanticker.projectboard.repository.ArticleCommentRepository;
import kr.semanticker.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComment(long l) {
        return List.of();
    }

    public void saveArticleComment(ArticleCommentDto of) {
    }
}
