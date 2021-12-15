
package one.digitalinnovation.PersonAPI.Repository;

import one.digitalinnovation.PersonAPI.dto.PersonDTO;
import one.digitalinnovation.PersonAPI.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person,Long>{

    public Person save(PersonDTO personDTO);
    //Database operations.
    
    
}
