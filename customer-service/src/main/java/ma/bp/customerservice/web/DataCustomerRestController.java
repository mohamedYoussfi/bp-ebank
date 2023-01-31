package ma.bp.customerservice.web;

import lombok.AllArgsConstructor;
import ma.bp.customerservice.entities.Customer;
import ma.bp.customerservice.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class DataCustomerRestController {
    private CustomerRepository customerRepository;
    @GetMapping("/customers")
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }
    @GetMapping("/customers/{id}")
    public ResponseEntity<?> customerById(@PathVariable Long id){
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer==null) {
            return ResponseEntity.internalServerError().body(Map.of("errorMessage","Customer Not found"));
        }
        return ResponseEntity.ok().body(customer);
    }
    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
}
