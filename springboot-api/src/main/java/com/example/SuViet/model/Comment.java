package com.example.SuViet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;

import java.util.Collection;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentID;

    @Column(columnDefinition = "ntext", nullable = false)
    private String commentText;

    @Column(columnDefinition = "date", nullable = false)
    private Date createdDate;

    @Column(nullable = false)
    private boolean enabled;

    public Comment(String commentText, Date createdDate, boolean enabled) {
        this.commentText = commentText;
        this.createdDate = createdDate;
        this.enabled = enabled;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "UserID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ArticleID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Article article;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Collection<RepliesComment> repliesComments;

}
