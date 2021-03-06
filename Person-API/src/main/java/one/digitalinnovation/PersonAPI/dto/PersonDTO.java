
package one.digitalinnovation.PersonAPI.dto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import javax.sql.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private long id;
    
    
    private String firstName;
    private String lastName;
    private String cpf;
    private String birthDate;
    private List<PhoneDTO> phones;
    
}
