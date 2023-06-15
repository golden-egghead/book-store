package com.example.SuViet.dto;

import java.util.List;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import com.example.SuViet.model.Article;
import com.example.SuViet.model.Comment;
import com.example.SuViet.model.Period;
import com.example.SuViet.model.RepliesComment;
import com.example.SuViet.model.Vote;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ArticleListDTO {
    private int articleID;
    private String title;
    private String context;
    private String photo;
    private Date createdDate;
    private boolean status;
    private int articleView;
    private String fullName;
    private int voteLevel;
    private String periodName;
    private List<String> comment;
    // private List<String> repliesComment;

    public ArticleListDTO(int articleID, String title, String context, String photo, Date createdDate,
        boolean status, int articleView, String fullName, int voteLevel, String periodName, List<String> comment) {
        this.articleID = articleID;
        this.title = title;
        this.context = context;
        this.photo = photo;
        this.createdDate = createdDate;
        this.status = status;
        this.articleView = articleView;
        this.fullName = fullName;
        this.voteLevel = voteLevel;
        this.periodName = periodName;
        this.comment = comment;
    }
    
    // public ArticleListDTO(int articleID, String title, String context, String photo, Date createdDate,
    //     boolean status, int articleView, String fullName, int voteLevel, String periodName, List<String> comment, List<String> Replies) {
    //     this.articleID = articleID;
    //     this.title = title;
    //     this.context = context;
    //     this.photo = photo;
    //     this.createdDate = createdDate;
    //     this.status = status;
    //     this.articleView = articleView;
    //     this.fullName = fullName;
    //     this.voteLevel = voteLevel;
    //     this.periodName = periodName;
    //     this.comment = comment;
    //     this.repliesComment = comment;
    // }

    public static ArticleListDTO convertToDTO(Article article) {
        ArticleListDTO dto = new ArticleListDTO();
        dto.setArticleID(article.getArticleID());
        dto.setTitle(article.getTitle());
        dto.setContext(article.getContext());
        dto.setPhoto(article.getPhoto());
        dto.setCreatedDate(article.getCreatedDate());
        dto.setStatus(article.isStatus());
        dto.setArticleView(article.getArticleView());
        dto.setFullName(article.getUser().getFullname());
        dto.setVoteLevel(getAverageVoteLevel(article.getVotes()));
        dto.setPeriodName(getPeriodNames(article.getPeriods()));
        dto.setComment(getArticleComments(article.getComments()));
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

    private static List<String> getArticleComments(Collection<Comment> comments) {
        return comments.stream().map(Comment::getCommentText).collect(Collectors.toList());
    } 
    
    // private static List<String> getArticleRepiesComment(Collection<RepliesComment> repliesComments) {
    //     return repliesComments.stream().map(RepliesComment::getCommentText).collect(Collectors.toList());
    // } 

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