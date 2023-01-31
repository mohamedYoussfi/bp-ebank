package ma.bp.customerservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
