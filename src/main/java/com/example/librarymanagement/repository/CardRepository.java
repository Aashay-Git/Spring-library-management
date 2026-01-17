package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {
}
