package ma.bp.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.bp.accountservice.entities.AccountTransaction;
import ma.bp.accountservice.enums.AccountType;

import java.util.List;
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountDetailsDTO {
    private String accountId;
    private double balance;
    private AccountType accountType;
    private Long customerId;
    private String customerFirstName;
    private String customerLastName;
    private List<AccountTransaction> accountTransactions;
}
