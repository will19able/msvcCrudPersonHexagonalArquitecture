package com.wpolog.sprintcloud.mcsv.personas.infra.inputadapter.http.person.mapper;

import com.wpolog.sprintcloud.mcsv.personas.domain.Person;
import com.wpolog.sprintcloud.mcsv.personas.infra.inputadapter.http.person.dto.CreatePersonRequest;
import com.wpolog.sprintcloud.mcsv.personas.infra.inputadapter.http.person.dto.UpdatePersonRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {MapperHelper.class}, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PersonMapper {

    PersonMapper INSTANCE= Mappers.getMapper(PersonMapper.class);

    @Mapping( source = "createPersonRequest.nombre", target="firstName", qualifiedByName = "stringCapitalize")
    @Mapping( source = "createPersonRequest.segundoNombre", target="secondName", qualifiedByName = "stringCapitalize")
    @Mapping( source = "createPersonRequest.apellido", target="surname", qualifiedByName = "stringCapitalize")
    @Mapping( source = "createPersonRequest.segundoApellido", target="secondSurname", qualifiedByName = "stringCapitalize")
    @Mapping( source = "createPersonRequest.tipoDocumento", target="typeDocument")
    @Mapping( source = "createPersonRequest.documento", target="document")
    @Mapping( source = "createPersonRequest.email", target="email")
    Person createPersonRequestToPerson(CreatePersonRequest createPersonRequest);

    @Mapping( source = "person.id", target="id")
    @Mapping( source = "person.firstName", target="nombre")
    @Mapping( source = "person.secondName", target="segundoNombre")
    @Mapping( source = "person.surname", target="apellido")
    @Mapping( source = "person.secondSurname", target="segundoApellido")
    @Mapping( source = "person.typeDocument", target="tipoDocumento")
    @Mapping( source = "person.document", target="documento")
    @Mapping( source = "person.email", target="email")
    CreatePersonRequest personToCreatePersonRequest(Person person);

    @Mapping( source = "updatePersonRequest.nombre", target="firstName", qualifiedByName = "stringCapitalize")
    @Mapping( source = "updatePersonRequest.segundoNombre", target="secondName", qualifiedByName = "stringCapitalize")
    @Mapping( source = "updatePersonRequest.apellido", target="surname", qualifiedByName = "stringCapitalize")
    @Mapping( source = "updatePersonRequest.segundoApellido", target="secondSurname", qualifiedByName = "stringCapitalize")
    @Mapping( source = "updatePersonRequest.tipoDocumento", target="typeDocument")
    @Mapping( source = "updatePersonRequest.documento", target="document")
    Person updatePersonRequestToPerson(UpdatePersonRequest updatePersonRequest);

    @Mapping( source = "person.id", target="id")
    @Mapping( source = "person.firstName", target="nombre")
    @Mapping( source = "person.secondName", target="segundoNombre")
    @Mapping( source = "person.surname", target="apellido")
    @Mapping( source = "person.secondSurname", target="segundoApellido")
    @Mapping( source = "person.typeDocument", target="tipoDocumento")
    @Mapping( source = "person.document", target="documento")
    @Mapping( source = "person.email", target="email")
    UpdatePersonRequest personToUpdatePersonRequest(Person person);

    List<CreatePersonRequest> listPersonToListCreatePersonRequest(List<Person> persons);

}
