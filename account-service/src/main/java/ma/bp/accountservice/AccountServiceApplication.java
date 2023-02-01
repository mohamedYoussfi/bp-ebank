package ma.bp.accountservice;

import ma.bp.accountservice.entities.AccountTransaction;
import ma.bp.accountservice.entities.BankAccount;
import ma.bp.accountservice.enums.AccountStatus;
import ma.bp.accountservice.enums.AccountType;
import ma.bp.accountservice.enums.TransactionType;
import ma.bp.accountservice.repository.AccountTransactionRepository;
import ma.bp.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository,
                            AccountTransactionRepository accountTransactionRepository){
     return args -> {
         for (int i = 0; i <6 ; i++) {
             BankAccount bankAccount=BankAccount.builder()
                     .accountId(UUID.randomUUID().toString())
                     .balance(1000+Math.random()*50000)
                     .createdAt(new Date())
                     .status(AccountStatus.CREATED)
                     .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                     .customerId(1L)
                     .build();
             BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
             for (int j = 0; j <10 ; j++) {
                 AccountTransaction accountTransaction=AccountTransaction.builder()
                         .amount(1000+Math.random()*60000)
                         .description("")
                         .date(new Date())
                         .type(Math.random()>0.5? TransactionType.DEBIT:TransactionType.CREDIT)
                         .bankAccount(savedBankAccount)
                         .build();
                 accountTransactionRepository.save(accountTransaction);
             }
         }
     }   ;
    }

}
