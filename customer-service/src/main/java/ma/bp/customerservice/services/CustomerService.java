package ma.bp.customerservice.services;

import ma.bp.customerservice.dtos.CustomerDTO;
import ma.bp.customerservice.exceptions.CustomerNotFoundException;
import ma.bp.customerservice.exceptions.EmailAlreadyExistException;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO) throws EmailAlreadyExistException;
    List<CustomerDTO> allCustomers();
    CustomerDTO customerById(Long id) throws CustomerNotFoundException;
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(Long id);
    List<CustomerDTO> serachCustomers(String kw);
}
