package ma.bp.customerservice;

import ma.bp.customerservice.config.CustomerConfigParams;
import ma.bp.customerservice.entities.Customer;
import ma.bp.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner run(CustomerRepository customerRepository){
        return (args) -> {
            for (int i = 1; i <=5 ; i++) {
                Customer customer=Customer.builder()
                        .firstName("First Name "+i)
                        .lastName("Last Name "+i)
                        .email("f.l"+i+"@gmail.com")
                        .build();
                customerRepository.save(customer);
            }
        };
    }
}
