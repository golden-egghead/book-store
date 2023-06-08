package com.example.SuViet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table(name = "tblHistoricalItems")
public class HistoricalItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int historicalItemID;

    @Column(columnDefinition = "ntext", nullable = false)
    private String type;

    @Column(columnDefinition = "ntext", nullable = false)
    private String name;

    @Column(columnDefinition = "ntext", nullable = false)
    private String nation;

    @Column(columnDefinition = "ntext", nullable = false)
    private String description;

    @Column(length = 200, nullable = false)
    private String photo;

    @Column(nullable = false)
    private boolean enabled;

    public HistoricalItem(int historicalItemID, String type, String name, String nation, String description, String photo, boolean enabled) {
        this.historicalItemID = historicalItemID;
        this.type = type;
        this.name = name;
        this.nation = nation;
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
