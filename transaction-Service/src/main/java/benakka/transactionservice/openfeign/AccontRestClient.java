package benakka.transactionservice.openfeign;

import benakka.transactionservice.model.Account;
import benakka.transactionservice.model.Status;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name="account-service")
public interface AccontRestClient {
    @GetMapping("/accounts/{id}")
    @CircuitBreaker(name = "accountService", fallbackMethod = "getDefaultAccount")
    Account getAccountById(@PathVariable String id);

    @GetMapping("/accounts")
    List<Account> getAccounts();

    default Account getDefaultAccount(String id, Exception e){
        return new Account(id, "noReference", Status.BLOCKED, "noCurrency", 0);
    }
}
