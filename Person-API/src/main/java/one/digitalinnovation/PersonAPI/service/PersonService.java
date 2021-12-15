
package one.digitalinnovation.PersonAPI.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import one.digitalinnovation.PersonAPI.Repository.PersonRepository;
import one.digitalinnovation.PersonAPI.dto.MessageResponseDTO;
import one.digitalinnovation.PersonAPI.dto.PersonDTO;
import one.digitalinnovation.PersonAPI.entity.Person;
import one.digitalinnovation.PersonAPI.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service //Put business rules.
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    public MessageResponseDTO createPeople(@RequestBody PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        
        Person savedperson = personRepository.save(personDTO);
        return MessageResponseDTO.builder().message("Created person." + savedperson.getId()).build();
    }

    public List<Person> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Person findById(long id) throws PersonNotFoundException {
        Optional<Person> optionalPerson =  personRepository.findById(id);
        if(optionalPerson.isEmpty()){
            throw new PersonNotFoundException(id);
        }
        return personMapper.toDTO(optionalPerson.get());
    }

    public void delete(long id) {
        personRepository.findById(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);
        
        Person savedperson = personRepository.save(personDTO);
        return MessageResponseDTO.builder().message("Updated person." + savedperson.getId()).build();
    }

    private Person verifyIfExists(long id) throws PersonNotFoundException{
        Optional<Person> verifyPersonById = personRepository.findById(id);
        if(verifyPersonById.isPresent()){
            return personRepository.getById(id);
        }
        return null;
    }

    
    
    
    
    
    
    
}
