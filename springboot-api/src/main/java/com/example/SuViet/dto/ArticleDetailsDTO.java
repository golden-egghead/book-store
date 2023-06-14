package com.example.SuViet.dto;

import java.util.Date;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ArticleDetailsDTO {
    private int articleID;
    private String title;
    private String context;
    private String photo;
    private Date createdDate;
    private boolean status;
    private int articleView;
    private boolean enabled;

    public ArticleDetailsDTO(int articleID, String title, String context, String photo, Date createdDate, boolean status, int articleView, boolean enabled) {
        this.articleID = articleID;
        this.title = title;
        this.context = context;
        this.photo = photo;
        this.createdDate = createdDate;
        this.status = status;
        this.articleView = articleView;
        this.enabled = enabled;
    }
}


