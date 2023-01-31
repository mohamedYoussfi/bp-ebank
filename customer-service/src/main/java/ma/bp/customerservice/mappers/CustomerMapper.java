package ma.bp.customerservice.mappers;

import ma.bp.customerservice.dtos.CustomerDTO;
import ma.bp.customerservice.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    private ModelMapper modelMapper=new ModelMapper();

    public Customer from(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO,Customer.class);
    }
    public CustomerDTO from(Customer customer){
        return modelMapper.map(customer,CustomerDTO.class);
    }
}
