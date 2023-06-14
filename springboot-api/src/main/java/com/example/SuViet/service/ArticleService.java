package com.example.SuViet.service;

import com.example.SuViet.dto.ArticleListDTO;
import com.example.SuViet.model.Article;
import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {

    Page<ArticleListDTO> getAllEnabledArticles(Pageable pageable);

    Page<ArticleListDTO> searchArticlesByTitle(String title, Pageable pageable);

    Article savedArticle(Article article);
}
