package kr.semanticker.projectboard.service;

import kr.semanticker.projectboard.domain.type.SearchType;
import kr.semanticker.projectboard.dto.ArticleDto;
import kr.semanticker.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
}
