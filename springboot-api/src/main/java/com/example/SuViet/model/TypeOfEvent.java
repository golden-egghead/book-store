package com.example.SuViet.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table(name = "tblTypeOfEvent")
public class TypeOfEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeOfEventID;

    @Column(columnDefinition = "ntext", nullable = false)
    private String typeOfEvent;

    @OneToOne
    @JoinColumn(name = "ArticleID")
    private Article article;
}
