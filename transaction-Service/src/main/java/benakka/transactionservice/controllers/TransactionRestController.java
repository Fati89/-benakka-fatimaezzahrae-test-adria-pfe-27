package benakka.transactionservice.controllers;

import benakka.transactionservice.entities.Transaction;
import benakka.transactionservice.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionRestController {
    private TransactionService transactionService;
    public TransactionRestController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions(){
        return transactionService.getAllTransactions();
    }

    @GetMapping("/transactions/{id}")
    public Transaction findTransactionById(@PathVariable String id){
        return transactionService.findTransactionById(id);
    }

    @PostMapping("/transactions")
    public Transaction saveTransaction(@RequestBody Transaction transaction){
        return transactionService.saveTransaction(transaction);
    }
}

