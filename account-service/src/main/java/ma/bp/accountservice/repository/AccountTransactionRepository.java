package ma.bp.accountservice.repository;

import ma.bp.accountservice.entities.AccountTransaction;
import ma.bp.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction,Long> {
    List<AccountTransaction> findByBankAccount_AccountId(String accountId);
}
