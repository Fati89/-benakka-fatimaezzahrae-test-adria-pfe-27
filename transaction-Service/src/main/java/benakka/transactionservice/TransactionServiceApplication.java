package benakka.transactionservice;

import benakka.transactionservice.entities.Transaction;
import benakka.transactionservice.model.Account;
import benakka.transactionservice.openfeign.AccontRestClient;
import benakka.transactionservice.repositories.TransactionRepository;
import com.thoughtworks.xstream.mapper.Mapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class TransactionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(TransactionRepository transactionRepository, AccontRestClient accontRestClient){

        return args -> {
//            List<Account> accounts = accontRestClient.getAccounts();

            transactionRepository.save(Transaction.builder()
                    .accountId("a9612e77-b4cf-4b83-b7ad-1be858ef6d05")
                    .amount(new BigDecimal("60000"))
                    .currency("cur1")
                    .merchantCategory("cat1")
                    .country("France")
                    .createdAt(new Date())
                    .build());
            transactionRepository.save(Transaction.builder()
                    .accountId("ee862d31-0372-4420-a71e-6f8ea8f91021")
                    .amount(new BigDecimal("70000"))
                    .currency("cur2")
                    .merchantCategory("cat2")
                    .country("Maroc")
                    .createdAt(new Date())
                    .build());
            transactionRepository.save(Transaction.builder()
                    .accountId("874ce8ac-f20f-4a6f-8eb4-2044390be13d")
                    .amount(new BigDecimal("50000"))
                    .currency("cur3")
                    .merchantCategory("cat3")
                    .country("US")
                    .createdAt(new Date())
                    .build());
        };
    }
}
