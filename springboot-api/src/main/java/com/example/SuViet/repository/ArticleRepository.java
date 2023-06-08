package com.example.SuViet.repository;

import com.example.SuViet.model.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Page<Article> findByEnabledTrue(Pageable pageable);

    @Query("SELECT a FROM Article a WHERE a.enabled = true AND lower(a.title) LIKE lower(concat('%', ?1, '%'))")
    Page<Article> searchByTitle(String title, Pageable pageable);

    Page<Article> findByPeriodsName(String period, Pageable pageable);

    Page<Article> findByTitleAndPeriodsName(String title, String period, Pageable pageable);

    Article save(Article article);
}