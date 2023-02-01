package ma.bp.customerservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "customer.params")
@Data
public class CustomerConfigParams {
    private int c1;
    private int c2;
}
