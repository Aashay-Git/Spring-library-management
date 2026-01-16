package com.example.librarymanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookid;

    private String name;

    @ManyToOne
    @JoinColumn
    Author author;
}
