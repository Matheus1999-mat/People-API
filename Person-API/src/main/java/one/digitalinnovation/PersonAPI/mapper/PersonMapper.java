
package one.digitalinnovation.PersonAPI.mapper;

import one.digitalinnovation.PersonAPI.dto.PersonDTO;
import one.digitalinnovation.PersonAPI.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;
@Mapper(componentModel ="spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    
    @Mapping(target="birthDate",source="birthDate",dateFormat="dd-MM-yyyy")
    Person toModel(PersonDTO dto );
    Person toDTO(Person dto);
  
    //public Person toModel(PersonDTO personDTO);

    //public PersonDTO toDTO(Person get);
    
}
