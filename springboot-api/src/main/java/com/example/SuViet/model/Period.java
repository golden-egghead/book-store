package com.example.SuViet.model;

import lombok.*;

import jakarta.persistence.*;
import java.util.Collection;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table(name = "tblPeriods")
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int periodID;

    @Column(columnDefinition = "ntext", nullable = false)
    private String periodName;

    @Column(nullable = false)
    private boolean enabled;

    @Column(name = "Image", columnDefinition = "ntext")
    private String image;

    public Period(int periodID, String periodName, boolean enabled, String image) {
        this.periodID = periodID;
        this.periodName = periodName;
        this.enabled = enabled;
        this.image = image;
    }

    @ManyToMany(mappedBy = "periods")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Collection<Article> articles;

    @OneToMany(mappedBy = "period")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Collection<Character> characters;

    @OneToMany(mappedBy = "period")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Collection<HistoricalSite> historicalSites;

    @OneToMany(mappedBy = "period")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Collection<HistoricalItem> historicalItems;

    @ManyToMany(mappedBy = "periods")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Collection<Video> videos;

    @ManyToMany(mappedBy = "periods")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Collection<Book> books;

}
