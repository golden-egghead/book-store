package com.example.SuViet.repository;

import com.example.SuViet.model.Article;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Page<Article> findByEnabledTrue(Pageable pageable);

    // @Query("SELECT a FROM Article a WHERE a.enabled = true AND lower(a.title)
    // LIKE lower(concat('%', ?1, '%'))")
    Page<Article> searchByTitle(String title, Pageable pageable);
    
    Article save(Article article);
}