package com.example.reksadana.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reksadana.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
}
