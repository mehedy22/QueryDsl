package com.spring.querydsl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String title;
    private String isbn;
    private int publicationYear;
    private double price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
