package benakka.transactionservice;

import benakka.transactionservice.entities.Transaction;
import benakka.transactionservice.repositories.TransactionRepository;
import com.thoughtworks.xstream.mapper.Mapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class TransactionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(TransactionRepository transactionRepository){
        return args -> {
            transactionRepository.save(Transaction.builder()
                    .accountId("")
                    .amount(new BigDecimal("60000"))
                    .currency("cur1")
                    .merchantCategory("cat1")
                    .country("France")
                    .createdAt(new Date())
                    .build());
            transactionRepository.save(Transaction.builder()
                    .accountId("")
                    .amount(new BigDecimal("70000"))
                    .currency("cur2")
                    .merchantCategory("cat2")
                    .country("Maroc")
                    .createdAt(new Date())
                    .build());
            transactionRepository.save(Transaction.builder()
                    .accountId("")
                    .amount(new BigDecimal("50000"))
                    .currency("cur3")
                    .merchantCategory("cat3")
                    .country("US")
                    .createdAt(new Date())
                    .build());
        };
    }
}
