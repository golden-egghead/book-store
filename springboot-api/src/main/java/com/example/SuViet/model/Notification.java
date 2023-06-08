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
@Table(name = "tblNotifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationID;

    @Column(columnDefinition = "ntext", nullable = false)
    private String message;

    @Column(columnDefinition = "date", nullable = false)
    private Date createdDate;

    @Column(nullable = false)
    private boolean enabled;

    public Notification(int notificationID, String message, Date createdDate, boolean enabled) {
        this.notificationID = notificationID;
        this.message = message;
        this.createdDate = createdDate;
        this.enabled = enabled;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "UserID")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;
}
