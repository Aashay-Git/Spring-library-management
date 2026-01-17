package com.example.librarymanagement.model;

import com.example.librarymanagement.LibraryManagementApplication;
import com.example.librarymanagement.enums.Genre;
import com.example.librarymanagement.enums.TransactionStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookid;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private int price;

    @ManyToOne
    @JoinColumn
    Author author;

    @OneToMany(mappedBy = "book")
    private List<Transaction> transactions = new ArrayList<>();


    public Book() {
    }

    public Book(int bookid, String title, Genre genre, int price, Author author) {
        this.bookid = bookid;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.author = author;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
