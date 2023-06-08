package com.example.SuViet.model;

import java.util.List;

public class ResponseArticleObject {
    private String status;
    private String message;
    private List<Article> articles;
    private int page;
    private int pageSize;
    private long totalArticles;
    private double totalPage;

    public ResponseArticleObject(String status, String message, List<Article> articles, int page, int pageSize,
            long totalArticles, double totalPage) {
        this.status = status;
        this.message = message;
        this.articles = articles;
        this.page = page;
        this.pageSize = pageSize;
        this.totalArticles = totalArticles;
        this.totalPage = totalPage;
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

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
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
