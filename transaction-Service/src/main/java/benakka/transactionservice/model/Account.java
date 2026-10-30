package benakka.transactionservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Account {
    private String id;
    private String customerReference;
    private Status status;
    private String currency;
    private double balance;

    public Account(String id, String noReference, Status status, String noCurrency, int i) {
    }
}
