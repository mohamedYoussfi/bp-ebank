package ma.bp.paymentservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "token")
@Data
public class PaymentConfigParams {
    private long refreshTokenTimeout;
    private long accessTokenTimeout;
}
