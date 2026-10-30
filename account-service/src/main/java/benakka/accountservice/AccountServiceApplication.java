package benakka.accountservice;

import benakka.accountservice.entities.Account;
import benakka.accountservice.enums.Status;
import benakka.accountservice.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(AccountRepository accountRepository){
        return args -> {
            accountRepository.save(Account.builder()
                    .customerReference("ref123")
                    .status(Math.random()>0.5? Status.ACTIVE:Status.BLOCKED)
                    .currency("cur1")
                    .balance(1000+Math.random()*60000)
                    .build());
            accountRepository.save(Account.builder()
                    .customerReference("ref456")
                    .status(Math.random()>0.5? Status.ACTIVE:Status.BLOCKED)
                    .currency("cur2")
                    .balance(1000+Math.random()*60000)
                    .build());
            accountRepository.save(Account.builder()
                    .customerReference("ref789")
                    .status(Math.random()>0.5? Status.ACTIVE:Status.BLOCKED)
                    .currency("cur3")
                    .balance(1000+Math.random()*60000)
                    .build());
        };
    }
}

