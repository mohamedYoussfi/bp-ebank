package ma.bp.accountservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.bp.accountservice.dto.BankAccountDetailsDTO;
import ma.bp.accountservice.dto.CustomerDTO;
import ma.bp.accountservice.entities.AccountTransaction;
import ma.bp.accountservice.entities.BankAccount;
import ma.bp.accountservice.exceptions.AccountNotFoundException;
import ma.bp.accountservice.feign.CustomerRestClient;
import ma.bp.accountservice.repository.AccountTransactionRepository;
import ma.bp.accountservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    private BankAccountRepository bankAccountRepository;
    private AccountTransactionRepository accountTransactionRepository;
    private CustomerRestClient customerRestClient;
    @Override
    public BankAccountDetailsDTO getAccountDetails(String accountId) throws AccountNotFoundException {
        BankAccount bankAccount=bankAccountRepository.findById(accountId).orElse(null);
        if(bankAccount==null) throw new AccountNotFoundException("Account not found");
        List<AccountTransaction> transactionList = accountTransactionRepository.findByBankAccount_AccountId(accountId);
        CustomerDTO customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        BankAccountDetailsDTO bankAccountDetailsDTO=BankAccountDetailsDTO.builder()
                .accountId(bankAccount.getAccountId())
                .balance(bankAccount.getBalance())
                .accountType(bankAccount.getType())
                .customerId(bankAccount.getCustomerId())
                .accountTransactions(transactionList)
                .customerFirstName(customer.getFirstName())
                .customerLastName(customer.getLastName())
                .build();
        return bankAccountDetailsDTO;
    }

    @Override
    public List<BankAccount> getAllAccounts() {
        return bankAccountRepository.findAll();
    }
}
