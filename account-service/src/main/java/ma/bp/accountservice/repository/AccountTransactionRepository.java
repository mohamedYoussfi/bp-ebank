package ma.bp.accountservice.repository;

import ma.bp.accountservice.entities.AccountTransaction;
import ma.bp.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction,Long> {
}
