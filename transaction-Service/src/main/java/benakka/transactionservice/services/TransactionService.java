package benakka.transactionservice.services;

import benakka.transactionservice.entities.Transaction;
import benakka.transactionservice.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public Transaction findTransactionById(String id){
        return transactionRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Transaction not found"));
    }

    public Transaction saveTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }
}
