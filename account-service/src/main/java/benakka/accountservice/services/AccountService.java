package benakka.accountservice.services;

import benakka.accountservice.entities.Account;
import benakka.accountservice.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account findAccountById(String id){
        return accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));
    }

    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }
}
