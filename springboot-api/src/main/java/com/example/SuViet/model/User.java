package com.example.SuViet.model;
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
@Table(name = "tblUsers")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserID;

    @Column(length = 50, nullable = false)
    private String mail;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(columnDefinition = "ntext", nullable = false)
    private String achievement;

    @Column(nullable = false)
    private int point;

    @Column(length = 50, nullable = false)
    private String fullname;

    @Column(columnDefinition = "date", nullable = false)
    private Date createdDate;

    @Column(nullable = false)
    private int reported;

    @Column(nullable = false)
    private boolean enabled;

    public User(int userID, String mail, String password, String achievement, int point, String fullname, Date createdDate, int reported, boolean enabled) {
        UserID = userID;
        this.mail = mail;
        this.password = password;
        this.achievement = achievement;
        this.point = point;
        this.fullname = fullname;
        this.createdDate = createdDate;
        this.reported = reported;
        this.enabled = enabled;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Notification> notifications;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<UserMiniGame> userMiniGames;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Comment> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Collection<Article> articles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Collection<Vote> votes;
}
