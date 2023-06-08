package com.example.SuViet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Data
@Table(name = "tblComments")
public class Comment {
    @Column(columnDefinition = "ntext", nullable = false)
    private String comment;

    @Column(columnDefinition = "date", nullable = false)
    private Date createdDate;

    @Column(nullable = false)
    private boolean enabled;

    public Comment(String comment, Date createdDate, boolean enabled) {
        this.comment = comment;
        this.createdDate = createdDate;
        this.enabled = enabled;
    }

    @Id
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "UserID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    @Id
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ArticleID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Article article;

}
