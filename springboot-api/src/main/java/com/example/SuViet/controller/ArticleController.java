package com.example.SuViet.controller;

import com.example.SuViet.model.Article;
import com.example.SuViet.model.ResponseArticleObject;
import com.example.SuViet.model.ResponseObject;
import com.example.SuViet.service.ArticleService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping(path = "/api/articles")
public class ArticleController {
    private final ArticleService articleService;
    private static final int PAGE_SIZE = 6;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("")
    public ResponseEntity<ResponseArticleObject> getAllEnabledArticles(
            @RequestParam(value = "title", defaultValue = "") String title,
            @RequestParam(value = "sortBy", defaultValue = "ArticleView") String sortBy,
            @RequestParam(value = "sortOrder", defaultValue = "desc") String sortOrder,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "period", defaultValue = "") String period) {

        try {
            Sort.Direction direction = Sort.Direction.fromString(sortOrder);
            Sort sort = Sort.by(direction, sortBy);
            PageRequest pageRequest = PageRequest.of(page - 1, PAGE_SIZE, sort);
            Page<Article> articlePage;

            if (title.isEmpty()) {
                articlePage = articleService.getAllEnabledArticles(pageRequest);
            } else {
                articlePage = articleService.searchArticlesByTitle(title, pageRequest);
            }

            // if (title.isEmpty()) {
            // if (period.isEmpty()) {
            // articlePage = articleService.getAllEnabledArticles(pageRequest);
            // } else {
            // articlePage = articleService.getArticlesByPeriod(period, pageRequest);
            // }
            // } else {
            // if (period.isEmpty()) {
            // articlePage = articleService.searchArticlesByTitle(title, pageRequest);
            // } else {
            // articlePage = articleService.searchArticlesByTitleAndPeriod(title, period,
            // pageRequest);
            // }
            // }

            List<Article> articleList = articlePage.getContent();
            int totalPages = articlePage.getTotalPages();
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseArticleObject("OK", "Querry Succesfully", articleList, page, PAGE_SIZE,
                            articlePage.getTotalElements(), totalPages));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResponseArticleObject("ERROR", "An error occurred", null, 0, 0, 0, 0));
        }

    }

    @PostMapping("")
    public ResponseEntity<ResponseObject> postAnArticle(@RequestBody Article article) {
        try {
            Article savedArticle = articleService.savedArticle(article);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    new ResponseObject("OK", "Article created successfully", savedArticle));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResponseObject("ERROR", "An error occurred", null));
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseObject> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ResponseObject("ERROR", "An error occurred", null));
    }

}
