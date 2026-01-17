package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Optional<Transaction> findByBook_bookidAndCard_cardid(int bookid, int cardid);
}
