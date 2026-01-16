package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.AuthorDTO;
import com.example.librarymanagement.model.Author;
import com.example.librarymanagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/addAuthor")
    public String addAuthor(@RequestBody AuthorDTO authorDTO) {
        try {
            return authorService.addAuthor(authorDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/findAuthor/{id}")
    public Author findAuthor(@PathVariable int id) {
        try {
            return authorService.findAuthor(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/findAllAuthors")
    public List<Author> findAllAuthors() {
        try {
            return authorService.findAllAuthors();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
