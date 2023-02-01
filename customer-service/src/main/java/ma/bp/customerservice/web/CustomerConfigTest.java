package ma.bp.customerservice.web;

import ma.bp.customerservice.config.CustomerConfigParams;
import ma.bp.customerservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RefreshScope
public class CustomerConfigTest {
    @Value("${customer.params.c1}")
    private int c1;
    @Value("${customer.params.c2}")
    private int c2;
    @Autowired
    private CustomerConfigParams customerConfigParams;
    @GetMapping("/configTest1")
    public Map<String, Object> configParams(){
        return Map.of("c1",c1,"c2",c2);
    }

    @GetMapping("/configTest2")
    public CustomerConfigParams configParams2(){
        return customerConfigParams;
    }

}
