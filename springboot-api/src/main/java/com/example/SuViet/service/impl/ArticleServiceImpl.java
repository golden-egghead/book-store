package com.example.SuViet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.SuViet.model.Article;
import com.example.SuViet.repository.ArticleRepository;
import com.example.SuViet.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Page<Article> getAllEnabledArticles(Pageable pageable) {
        return articleRepository.findByEnabledTrue(pageable);
    }

    @Override
    public Page<Article> searchArticlesByTitle(String title, Pageable pageable) {
        return articleRepository.searchByTitle(title, pageable);
    }

    @Override
    public Page<Article> getArticlesByPeriod(String period, Pageable pageable) {
        return articleRepository.findByPeriodsName(period, pageable);
    }

    @Override
    public Page<Article> searchArticlesByTitleAndPeriod(String title, String period, Pageable pageable) {
        return articleRepository.findByTitleAndPeriodsName(title, period, pageable);
    }

    @Override
    public Article savedArticle(Article article) {
        return articleRepository.save(article);
    }
}
