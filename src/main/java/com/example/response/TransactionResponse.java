package com.example.response;

import java.util.List;
import com.example.reksadana.model.Transaction;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
    private int statusCode;
    private String message;
    private List<Transaction> data;
}