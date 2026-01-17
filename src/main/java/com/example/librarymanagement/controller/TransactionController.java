package com.example.librarymanagement.controller;

import com.example.librarymanagement.dto.TransactionDTO;
import com.example.librarymanagement.model.Transaction;
import com.example.librarymanagement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/addTransaction")
    public String addTransaction(@RequestBody TransactionDTO transactionDTO){
        try{
            return transactionService.addTransaction(transactionDTO);
        }catch (RuntimeException e){
            return "Failed to get card or book";
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/findAllTransactions")
    public List<Transaction> findAll(){
        try{
            return transactionService.findAll();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/submit/{bookid}/{cardid}")
    public Transaction submit(@PathVariable int bookid, @PathVariable int cardid){
        try{
            return transactionService.returnBook(cardid, bookid);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
