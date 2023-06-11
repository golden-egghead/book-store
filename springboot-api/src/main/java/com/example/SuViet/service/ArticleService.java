package com.example.SuViet.service;

import com.example.SuViet.model.Article;
import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {

    Page<Article> getAllEnabledArticles(Pageable pageable);

    Page<Article> searchArticlesByTitle(String title, Pageable pageable);

    // Page<Article> getArticlesByPeriod(String period, Pageable pageable);

    // Page<Article> searchArticlesByTitleAndPeriod(String title, String period,
    // Pageable pageable);

    Article savedArticle(Article article);
}
