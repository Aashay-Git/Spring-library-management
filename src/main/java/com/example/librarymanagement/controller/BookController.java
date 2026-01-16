package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.BookDTO;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public String addBook(@RequestBody BookDTO bookDTO) {
        try {
            return bookService.addBook(bookDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/findBook/{id}")
    public Book findBook(@PathVariable int id) {
        try {
            return bookService.findBook(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/findAllBooks")
    public List<Book> findAllBooks() {
        try {
            return bookService.findAllBooks();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
