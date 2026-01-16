package com.example.librarymanagement.service;

import com.example.librarymanagement.dto.BookDTO;
import com.example.librarymanagement.model.Book;

import java.util.List;

public interface BookService {
    String addBook(BookDTO bookDTO);

    Book findBook(int id);

    List<Book> findAllBooks();
}
