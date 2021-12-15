
package one.digitalinnovation.PersonAPI.PersonController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import one.digitalinnovation.PersonAPI.dto.MessageResponseDTO;
import one.digitalinnovation.PersonAPI.dto.PersonDTO;
import one.digitalinnovation.PersonAPI.entity.Person;
import one.digitalinnovation.PersonAPI.service.PersonNotFoundException;
//import one.digitalinnovation.PersonAPI.entity.Person;
import one.digitalinnovation.PersonAPI.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/people")
public class PersonController {
        
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPeople(@RequestBody PersonDTO personDTO){
        return personService.createPeople(personDTO);
    }
    
    @GetMapping
    public List<Person> listAll(){
        return personService.listAll();
        
    }
    
    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable long id,@RequestBody PersonDTO personDTO) throws PersonNotFoundException{
        return personService.updateById(id,personDTO);
    }
    
    @GetMapping("/{id}")
    public Person findById(@PathVariable long id){
        try {
            return personService.findById(id);
        } catch (PersonNotFoundException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
        
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(long id){
        personService.delete(id);
    }
    
    
    
}
