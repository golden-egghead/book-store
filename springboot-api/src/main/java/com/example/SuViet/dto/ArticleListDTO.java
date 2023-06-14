package com.example.SuViet.dto;

import java.util.Collection;
import java.util.Date;

import com.example.SuViet.model.Article;
import com.example.SuViet.model.Period;
import com.example.SuViet.model.Vote;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ArticleListDTO {
    private int articleID;
    private String title;
    private String photo;
    private Date createdDate;
    private int articleView;
    private String fullName;
    private int voteLevel;
    private String periodName;

    public ArticleListDTO(int articleID, String title, String photo, Date createdDate,
        int articleView, String fullName, int voteLevel, String periodName) {
        this.articleID = articleID;
        this.title = title;
        this.photo = photo;
        this.createdDate = createdDate;
        this.articleView = articleView;
        this.fullName = fullName;
        this.voteLevel = voteLevel;
        this.periodName = periodName;
    }

    public static ArticleListDTO convertToDTO(Article article) {
        ArticleListDTO dto = new ArticleListDTO();
        dto.setArticleID(article.getArticleID());
        dto.setTitle(article.getTitle());
        dto.setPhoto(article.getPhoto());
        dto.setCreatedDate(article.getCreatedDate());
        dto.setArticleView(article.getArticleView());
        dto.setFullName(article.getUser().getFullname());
        dto.setVoteLevel(getAverageVoteLevel(article.getVotes()));
        dto.setPeriodName(getPeriodNames(article.getPeriods()));
        return dto;
    }

    public Article convertToEntity() {
        Article article = new Article();
        article.setArticleID(this.articleID);
        article.setTitle(this.title);
        article.setPhoto(this.photo);
        article.setCreatedDate(this.createdDate);
        article.setArticleView(this.articleView);
        return article;
    }

    private static int getAverageVoteLevel(Collection<Vote> votes) {
    int totalVotes = votes.size();
    int totalVoteLevel = 0;
    for (Vote vote : votes) {
        totalVoteLevel += vote.getVoteLevel();
    }
    if (totalVotes > 0) {
        return totalVoteLevel / totalVotes;
    } else {
        return 0;
    }
}

    private static String getPeriodNames(Collection<Period> periods) {
        if (periods.isEmpty()) {
            return "";
        }

        StringBuilder periodNameBuilder = new StringBuilder();
        for (Period period : periods) {
            periodNameBuilder.append(period.getPeriodName()).append(", ");
        }
        periodNameBuilder.delete(periodNameBuilder.length() - 2, periodNameBuilder.length());
        return periodNameBuilder.toString();
    }
}