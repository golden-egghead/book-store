package com.example.SuViet.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.SuViet.dto.ArticleListDTO;
import com.example.SuViet.model.Article;
import com.example.SuViet.repository.ArticleRepository;
import com.example.SuViet.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Page<ArticleListDTO> getAllEnabledArticles(Pageable pageable) {
        Page<Article> articlesPage = articleRepository.findByEnabledTrue(pageable);
        return articlesPage.map(ArticleListDTO::convertToDTO);
    }

    @Override
    public Page<ArticleListDTO> searchArticlesByTitle(String title, Pageable pageable) {
        Page<Article> articlesPage = articleRepository.searchByTitle(title, pageable);
        return articlesPage.map(ArticleListDTO::convertToDTO);
    }

    @Override
    public Article savedArticle(Article article) {
        return articleRepository.save(article);
    }
}
