package benakka.accountservice.controllers;

import benakka.accountservice.entities.Account;
import benakka.accountservice.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountRestController {
    private AccountService accountService;
    public AccountRestController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account findAccountById(@PathVariable String id){
        return accountService.findAccountById(id);
    }

    @PostMapping("/accounts")
    public Account saveAccount(@RequestBody Account account){
        return accountService.saveAccount(account);
    }
}

