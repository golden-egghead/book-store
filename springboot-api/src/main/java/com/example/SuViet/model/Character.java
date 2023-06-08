package com.example.SuViet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table(name = "tblCharacters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int characterID;

    @Column(columnDefinition = "ntext", nullable = false)
    private String characterName;

    @Column(columnDefinition = "ntext", nullable = false)
    private String story;

    @Column(columnDefinition = "ntext", nullable = false)
    private String estate;

    @Column(nullable = false)
    private boolean enabled;

    public Character(int characterID, String characterName, String story, String estate, boolean enabled) {
        this.characterID = characterID;
        this.characterName = characterName;
        this.story = story;
        this.estate = estate;
        this.enabled = enabled;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "PeriodID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Period period;
}
