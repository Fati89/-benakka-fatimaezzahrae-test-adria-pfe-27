package benakka.transactionservice.entities;

import benakka.transactionservice.model.Account;
import jakarta.persistence.*;
import jakarta.ws.rs.SeBootstrap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String accountId;
    private BigDecimal amount;
    private String currency;
    private String merchantCategory;
    private String country;
    private Date createdAt;
    @Transient
    private Account account;

}