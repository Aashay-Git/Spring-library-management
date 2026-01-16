package com.example.librarymanagement.service;

import com.example.librarymanagement.dto.AuthorDTO;
import com.example.librarymanagement.model.Author;

import java.util.List;

public interface AuthorService {
    String addAuthor(AuthorDTO authorDTO);

    Author findAuthor(int id);

    List<Author> findAllAuthors();
}
