package com.example.librarymanagement.service.implementations;

import com.example.librarymanagement.dto.BookDTO;
import com.example.librarymanagement.model.Author;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.repository.AuthorRepository;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public String addBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setGenre(bookDTO.getGenre());
        book.setPrice(bookDTO.getPrice());

        Author author = authorRepository.findById(bookDTO.getAuthorId()).orElse(null);
        if (author != null) {
            book.setAuthor(author);
        } else {
            throw new RuntimeException("Author not found");
        }

        bookRepository.save(book);
        return "Book Added Successfully";
    }

    @Override
    public Book findBook(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}
