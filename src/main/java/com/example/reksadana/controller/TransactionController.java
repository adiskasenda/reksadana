package com.example.reksadana.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.reksadana.repository.TransactionRepository;
import com.example.response.TransactionResponse;
import com.example.reksadana.model.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/v1")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/transaction/all")
    public ResponseEntity<TransactionResponse> getAllTransaction() {
        String message = "";
        try {
            List<Transaction> transaction = transactionRepository.findAll();
            message = "Get Transaction Success";
            return ResponseEntity.status(HttpStatus.OK).body(new TransactionResponse(HttpStatus.OK.value(), message, transaction));
        } catch (Exception e) {
            message = "Get Transaction Failed : " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new TransactionResponse(HttpStatus.BAD_REQUEST.value(), message, null));
        }
    }

    @PostMapping("/transaction/create")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
