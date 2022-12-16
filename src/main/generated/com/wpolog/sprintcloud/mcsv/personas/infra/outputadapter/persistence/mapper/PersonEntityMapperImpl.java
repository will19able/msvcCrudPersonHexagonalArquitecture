package com.wpolog.sprintcloud.mcsv.personas.infra.outputadapter.persistence.mapper;

import com.wpolog.sprintcloud.mcsv.personas.domain.Person;
import com.wpolog.sprintcloud.mcsv.personas.domain.Person.PersonBuilder;
import com.wpolog.sprintcloud.mcsv.personas.infra.outputadapter.persistence.entity.PersonEntity;
import com.wpolog.sprintcloud.mcsv.personas.infra.outputadapter.persistence.entity.PersonEntity.PersonEntityBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-25T08:23:44-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class PersonEntityMapperImpl implements PersonEntityMapper {

    @Override
    public PersonEntity personToPersonEntity(Person person) {

        PersonEntityBuilder<?, ?> personEntity = PersonEntity.builder();

        if ( person != null ) {
            if ( person.getId() != null ) {
                personEntity.id( person.getId() );
            }
            if ( person.getFirstName() != null ) {
                personEntity.firstName( person.getFirstName() );
            }
            if ( person.getSecondName() != null ) {
                personEntity.secondName( person.getSecondName() );
            }
            if ( person.getSurname() != null ) {
                personEntity.surname( person.getSurname() );
            }
            if ( person.getSecondSurname() != null ) {
                personEntity.secondSurname( person.getSecondSurname() );
            }
            if ( person.getTypeDocument() != null ) {
                personEntity.typeDocument( person.getTypeDocument() );
            }
            if ( person.getDocument() != null ) {
                personEntity.document( person.getDocument() );
            }
            if ( person.getEmail() != null ) {
                personEntity.email( person.getEmail() );
            }
        }

        return personEntity.build();
    }

    @Override
    public Person personEntityToPerson(PersonEntity personEntity) {

        PersonBuilder<?, ?> person = Person.builder();

        if ( personEntity != null ) {
            if ( personEntity.getId() != null ) {
                person.id( personEntity.getId() );
            }
            if ( personEntity.getFirstName() != null ) {
                person.firstName( personEntity.getFirstName() );
            }
            if ( personEntity.getSecondName() != null ) {
                person.secondName( personEntity.getSecondName() );
            }
            if ( personEntity.getSurname() != null ) {
                person.surname( personEntity.getSurname() );
            }
            if ( personEntity.getSecondSurname() != null ) {
                person.secondSurname( personEntity.getSecondSurname() );
            }
            if ( personEntity.getTypeDocument() != null ) {
                person.typeDocument( personEntity.getTypeDocument() );
            }
            if ( personEntity.getDocument() != null ) {
                person.document( personEntity.getDocument() );
            }
            if ( personEntity.getEmail() != null ) {
                person.email( personEntity.getEmail() );
            }
        }

        return person.build();
    }

    @Override
    public List<Person> listPersonEntityTolistPerson(List<PersonEntity> lstPersonEntity) {
        if ( lstPersonEntity == null ) {
            return new ArrayList<Person>();
        }

        List<Person> list = new ArrayList<Person>( lstPersonEntity.size() );
        for ( PersonEntity personEntity : lstPersonEntity ) {
            list.add( personEntityToPerson( personEntity ) );
        }

        return list;
    }
}
