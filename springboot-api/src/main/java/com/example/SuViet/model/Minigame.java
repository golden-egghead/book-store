package com.example.SuViet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
import java.util.Collection;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Data
@Table(name = "tblMiniGames")
public class Minigame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int minigameID;

    @Column(columnDefinition = "ntext", nullable = false)
    private String minigameName;

    @Column(nullable = false)
    private boolean enabled;

    public Minigame(int minigameID, String minigameName, boolean enabled) {
        this.minigameID = minigameID;
        this.minigameName = minigameName;
        this.enabled = enabled;
    }

    @OneToMany(mappedBy = "minigame", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<UserMiniGame> userMiniGames;

    @OneToMany(mappedBy = "minigame", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Collection<PairOfQuizz> pairOfQuizzes;

}
