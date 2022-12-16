package com.wpolog.sprintcloud.mcsv.personas.infra.outputadapter.persistence.mapper;

import com.wpolog.sprintcloud.mcsv.personas.domain.Person;
import com.wpolog.sprintcloud.mcsv.personas.infra.outputadapter.persistence.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PersonEntityMapper {

    PersonEntityMapper INSTANCE= Mappers.getMapper(PersonEntityMapper.class);

    PersonEntity personToPersonEntity(Person person);

    Person personEntityToPerson(PersonEntity personEntity);

    List<Person> listPersonEntityTolistPerson(List<PersonEntity> lstPersonEntity);
}
