package com.example.librarymanagement.service.implementations;

import com.example.librarymanagement.dto.AuthorDTO;
import com.example.librarymanagement.model.Author;
import com.example.librarymanagement.repository.AuthorRepository;
import com.example.librarymanagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImplementation implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public String addAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        author.setAge(authorDTO.getAge());
        author.setEmail(authorDTO.getEmail());
        authorRepository.save(author);
        return "Author Added Successfully";
    }

    @Override
    public Author findAuthor(int id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }
}
