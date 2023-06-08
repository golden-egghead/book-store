package com.example.SuViet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table(name = "tblUserMiniGame")
public class UserMiniGame {
    @Id
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "userID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    @Id
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "MiniGameID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Minigame minigame;

    @Column(nullable = false)
    private int UserGamePoint;

    public UserMiniGame(int userGamePoint) {
        UserGamePoint = userGamePoint;
    }
}
