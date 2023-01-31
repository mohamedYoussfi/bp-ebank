package ma.bp.customerservice.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.bp.customerservice.dtos.CustomerDTO;
import ma.bp.customerservice.entities.Customer;
import ma.bp.customerservice.exceptions.CustomerNotFoundException;
import ma.bp.customerservice.exceptions.EmailAlreadyExistException;
import ma.bp.customerservice.mappers.CustomerMapper;
import ma.bp.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j @AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) throws EmailAlreadyExistException {
        if(customerRepository.verifyIdEmailExists(customerDTO.getEmail()))
            throw new EmailAlreadyExistException(String.format("Email %s already exists",customerDTO.getEmail()));
        Customer customer = customerMapper.from(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        CustomerDTO result = customerMapper.from(savedCustomer);
        return result;
    }

    @Override
    public List<CustomerDTO> allCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDTO> result = customerList.stream()
                .map(customerMapper::from).collect(Collectors.toList());
        /*
        List<CustomerDTO> customerDTOS=new ArrayList<>();
        for(Customer customer:customerList){
            CustomerDTO customerDTO = customerMapper.from(customer);
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
         */
        return result;
    }

    @Override
    public CustomerDTO customerById(Long id) throws CustomerNotFoundException {
        Customer customer=customerRepository.findById(id).orElse(null);
        if(customer==null) throw new CustomerNotFoundException("Customer Not Found "+id);
        CustomerDTO customerDTO = customerMapper.from(customer);
        return customerDTO;
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }

    @Override
    public List<CustomerDTO> serachCustomers(String kw) {
        return null;
    }
}
