package kr.semanticker.projectboard.controller;

import kr.semanticker.projectboard.domain.type.SearchType;
import kr.semanticker.projectboard.dto.response.ArticleResponse;
import kr.semanticker.projectboard.dto.response.ArticleWithCommentsResponse;
import kr.semanticker.projectboard.service.ArticleService;
import kr.semanticker.projectboard.service.PaginationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/articles")
@Controller
public class ArticleController {

    private final ArticleService articleService;
    private final PaginationService paginationService;

    @GetMapping
    public String articles(
            @RequestParam(required = false) SearchType searchType,
            @RequestParam(required = false) String searchValue,
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable,
            ModelMap map
    ) {
        Page<ArticleResponse> articles = articleService.searchArticles(searchType, searchValue, pageable).map(ArticleResponse::from);
        List<Integer> barNumbers = paginationService.getPaginationBarNumbers(pageable.getPageNumber(), articles.getTotalPages());

        map.addAttribute("articles", articles);
        map.addAttribute("paginationBarNumbers", barNumbers);
        map.addAttribute("searchTypes", SearchType.values());


        return "articles/index";
    }

    @GetMapping("/{articleId}")
    public String article(@PathVariable Long articleId, ModelMap map) {
        ArticleWithCommentsResponse reponse = ArticleWithCommentsResponse.from(articleService.getArticle(articleId));
        map.addAttribute("article",reponse);
        map.addAttribute("articleComments", reponse.articleCommentsResponse());

        return "articles/detail";
    }

    @GetMapping("/search-hashtag")
    public String searchArricleHashtag(
            @RequestParam(required = false) SearchType searchType,
            @RequestParam(required = false) String searchValue,
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable,
            ModelMap map
    ) {
        return "articles/search-hashtag";
    }


}
