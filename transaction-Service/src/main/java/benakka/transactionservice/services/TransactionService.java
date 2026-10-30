package benakka.transactionservice.services;

import benakka.transactionservice.entities.Transaction;
import benakka.transactionservice.openfeign.AccontRestClient;
import benakka.transactionservice.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private AccontRestClient accontRestClient;
    public TransactionService(TransactionRepository transactionRepository, AccontRestClient accontRestClient){
        this.transactionRepository = transactionRepository;
        this.accontRestClient = accontRestClient;
    }

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public Transaction findTransactionById(String id){
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Transaction not found"));
        transaction.setAccount(accontRestClient.getAccountById(transaction.getAccountId()));
        return transaction;
    }

    public Transaction saveTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }
}
