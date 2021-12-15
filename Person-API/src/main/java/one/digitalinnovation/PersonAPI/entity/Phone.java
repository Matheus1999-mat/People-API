
package one.digitalinnovation.PersonAPI.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
//import one.digitalinnovation.PersonAPI.enums.PhoneType;

@Entity
@Data//Insert getters and setters.
@Builder
@AllArgsConstructor//Insert constructors.
@NoArgsConstructor
public class Phone {
    @Id//If it is an entity, it must have a primary key.
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    //private PhoneType type;
    @Column(nullable=false)//It can't be a null value.
    private String number;
    
}
