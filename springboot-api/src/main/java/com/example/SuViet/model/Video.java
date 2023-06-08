package com.example.SuViet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table(name = "tblVideos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int videoID;

    @Column(columnDefinition = "ntext", nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String video;

    @Column(columnDefinition = "ntext", nullable = false)
    private String description;

    @Column(nullable = false, columnDefinition = "date")
    private Date createdDate;
    private boolean enabled;

    public Video(int videoID, String title, String video, String description, Date createdDate, boolean enabled) {
        this.videoID = videoID;
        this.title = title;
        this.video = video;
        this.description = description;
        this.createdDate = createdDate;
        this.enabled = enabled;
    }

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinTable(name = "tblPeriodVideo",
            joinColumns = @JoinColumn(name = "VideoID"),
            inverseJoinColumns = @JoinColumn(name = "PeriodID")
    )
    private Collection<Period> periods;
}
