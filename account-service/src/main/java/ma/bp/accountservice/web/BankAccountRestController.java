package ma.bp.accountservice.web;

import lombok.AllArgsConstructor;
import ma.bp.accountservice.dto.BankAccountDetailsDTO;
import ma.bp.accountservice.entities.BankAccount;
import ma.bp.accountservice.exceptions.AccountNotFoundException;
import ma.bp.accountservice.service.BankAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class BankAccountRestController {
    private BankAccountService bankAccountService;
    @GetMapping("/accounts/{id}")
    public ResponseEntity<?> getAccountDetails(@PathVariable(name = "id") String accountId){
        try {
            BankAccountDetailsDTO accountDetails = bankAccountService.getAccountDetails(accountId);
            return ResponseEntity.ok().body(accountDetails);

        } catch (AccountNotFoundException e) {
            return ResponseEntity.internalServerError().body(Map.of("errorMessage",e.getMessage()));
        }
    }
    @GetMapping("/accounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountService.getAllAccounts();
    }
}
