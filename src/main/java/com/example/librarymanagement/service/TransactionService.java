package com.example.librarymanagement.service;

import com.example.librarymanagement.dto.TransactionDTO;
import com.example.librarymanagement.model.Transaction;

import java.util.List;

public interface TransactionService {
    public String addTransaction(TransactionDTO transactionDTO);
    public List<Transaction> findAll();
}
