package com.example.librarymanagement.service.implementations;

import com.example.librarymanagement.dto.TransactionDTO;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.model.Card;
import com.example.librarymanagement.model.Transaction;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.CardRepository;
import com.example.librarymanagement.repository.StudentRepository;
import com.example.librarymanagement.repository.TransactionRepository;
import com.example.librarymanagement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImplementation implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    BookRepository bookRepository;

    @Override
    public String addTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        Card card = cardRepository.findById(transactionDTO.getCardid()).orElse(null);
        Book book = bookRepository.findById(transactionDTO.getBookid()).orElse(null);

        if(card == null || book == null){

            throw new RuntimeException("Failed to get card or book");
//            return "Failed to get card or book";
        }

        transaction.setCard(card);
        transaction.setBook(book);
        transaction.setTransactionStatus(transactionDTO.getTransactionStatus());
        transactionRepository.save(transaction);

        return "Transaction Added";
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }
}
