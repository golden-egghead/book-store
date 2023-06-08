package com.example.SuViet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
@Table(name = "tblBooks")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookID;

    @Column(columnDefinition = "nvarchar", length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "nvarchar", length = 50, nullable = false)
    private String author;

    @Column(columnDefinition = "nvarchar", length = 50, nullable = false)
    private String category;

    @Column(columnDefinition = "nvarchar", length = Integer.MAX_VALUE, nullable = false)
    private String description;

    @Column(nullable = false)
    private int pageNumber;

    @Column(length = 5, nullable = false)
    private String yearOfPublication;

    @Column(columnDefinition = "date", nullable = false)
    public Date createdDate;

    @Column(columnDefinition = "ntext", nullable = false)
    private String publisher;

    @Column(nullable = false)
    private double price;

    @Column(length = 200, nullable = false)
    private String cover;

    @Column(nullable = false)
    private boolean enabled;

    public Book(int bookID, String title, String author, String category, String description, int pageNumber, String yearOfPublication, Date createdDate, String publisher, double price, String cover, boolean enabled) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.category = category;
        this.description = description;
        this.pageNumber = pageNumber;
        this.yearOfPublication = yearOfPublication;
        this.createdDate = createdDate;
        this.publisher = publisher;
        this.price = price;
        this.cover = cover;
        this.enabled = enabled;
    }

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinTable(name = "tblPeriodBook",
            joinColumns = @JoinColumn(name = "BookID"),
            inverseJoinColumns = @JoinColumn(name = "PeriodID")
    )
    private Collection<Period> periods;
}
