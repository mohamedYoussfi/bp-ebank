package ma.bp.paymentservice.web;

import ma.bp.paymentservice.config.PaymentConfigParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentConfigTestController {
    @Autowired
    private PaymentConfigParams paymentConfigParams;
    @GetMapping("/configTestParams")
    public PaymentConfigParams configParams(){
        return paymentConfigParams;
    }

}
