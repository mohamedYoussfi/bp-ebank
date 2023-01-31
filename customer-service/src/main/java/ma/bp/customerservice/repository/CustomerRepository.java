package ma.bp.customerservice.repository;

import ma.bp.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("select case when count(c)>0 then true else false END from Customer c where c.email=?1")
    Boolean verifyIdEmailExists(String email);
    @Query("select c from Customer c where c.firstName like :kw or c.lastName like :kw")
    List<Customer> searchCustomers(@Param("kw") String kw);
}
