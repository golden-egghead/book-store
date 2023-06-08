package com.example.SuViet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table(name = "tblHistoricalSites")
public class HistoricalSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int historicalSiteID;

    @Column(columnDefinition = "ntext", nullable = false)
    private String location;

    @Column(columnDefinition = "ntext", nullable = false)
    private String description;

    @Column(length = 200, nullable = false)
    private String photo;

    @Column(nullable = false)
    private boolean enabled;

    public HistoricalSite(int historicalSiteID, String location, String description, String photo, boolean enabled) {
        this.historicalSiteID = historicalSiteID;
        this.location = location;
        this.description = description;
        this.photo = photo;
        this.enabled = enabled;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "PeriodID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Period period;
}
