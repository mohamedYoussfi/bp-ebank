package ma.bp.accountservice.service;

import ma.bp.accountservice.dto.BankAccountDetailsDTO;
import ma.bp.accountservice.entities.BankAccount;
import ma.bp.accountservice.exceptions.AccountNotFoundException;

import java.util.List;

public interface BankAccountService {
    BankAccountDetailsDTO getAccountDetails(String accountId) throws AccountNotFoundException;

    List<BankAccount> getAllAccounts();
}
