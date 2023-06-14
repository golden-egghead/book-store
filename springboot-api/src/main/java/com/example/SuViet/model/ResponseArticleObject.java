package com.example.SuViet.model;

import java.util.List;

import com.example.SuViet.dto.ArticleListDTO;

public class ResponseArticleObject {
    private String status;
    private String message;
    private int page;
    private int pageSize;
    private long totalArticles;
    private double totalPage;
    private List<ArticleListDTO> articles;

    public ResponseArticleObject(String status, String message, int page, int pageSize,
            long totalArticles, double totalPage, List<ArticleListDTO> articles) {
        this.status = status;
        this.message = message;
        this.page = page;
        this.pageSize = pageSize;
        this.totalArticles = totalArticles;
        this.totalPage = totalPage;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ArticleListDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleListDTO> articles) {
        this.articles = articles;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalArticles() {
        return totalArticles;
    }

    public void setTotalArticles(long totalArticles) {
        this.totalArticles = totalArticles;
    }

    public double getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(double totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "ResponseArticleObject [status=" + status + ", message=" + message + ", articles=" + articles + ", page="
                + page + ", pageSize=" + pageSize + ", totalArticles=" + totalArticles + ", totalPage=" + totalPage
                + "]";
    }

}
