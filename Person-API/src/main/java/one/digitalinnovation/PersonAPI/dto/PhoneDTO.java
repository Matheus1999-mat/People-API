
package one.digitalinnovation.PersonAPI.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
    private long id;
    
    
    private String number;
    
}
