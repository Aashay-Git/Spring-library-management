package com.example.librarymanagement.dto;

import com.example.librarymanagement.enums.TransactionStatus;

public class TransactionDTO {
    private int cardid;
    private int bookid;
    TransactionStatus transactionStatus;

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getCardid() {
        return cardid;
    }

    public void setCardid(int cardid) {
        this.cardid = cardid;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
