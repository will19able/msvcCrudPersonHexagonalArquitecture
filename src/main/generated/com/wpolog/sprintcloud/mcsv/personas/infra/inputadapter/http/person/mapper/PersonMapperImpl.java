package com.wpolog.sprintcloud.mcsv.personas.infra.inputadapter.http.person.mapper;

import com.wpolog.sprintcloud.mcsv.personas.domain.Person;
import com.wpolog.sprintcloud.mcsv.personas.domain.Person.PersonBuilder;
import com.wpolog.sprintcloud.mcsv.personas.infra.inputadapter.http.person.dto.CreatePersonRequest;
import com.wpolog.sprintcloud.mcsv.personas.infra.inputadapter.http.person.dto.CreatePersonRequest.CreatePersonRequestBuilder;
import com.wpolog.sprintcloud.mcsv.personas.infra.inputadapter.http.person.dto.UpdatePersonRequest;
import com.wpolog.sprintcloud.mcsv.personas.infra.inputadapter.http.person.dto.UpdatePersonRequest.UpdatePersonRequestBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-25T08:23:47-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class PersonMapperImpl implements PersonMapper {

    private final MapperHelper mapperHelper = new MapperHelper();

    @Override
    public Person createPersonRequestToPerson(CreatePersonRequest createPersonRequest) {

        PersonBuilder<?, ?> person = Person.builder();

        if ( createPersonRequest != null ) {
            if ( createPersonRequest.getNombre() != null ) {
                person.firstName( mapperHelper.stringCapitalize( createPersonRequest.getNombre() ) );
            }
            if ( createPersonRequest.getSegundoNombre() != null ) {
                person.secondName( mapperHelper.stringCapitalize( createPersonRequest.getSegundoNombre() ) );
            }
            if ( createPersonRequest.getApellido() != null ) {
                person.surname( mapperHelper.stringCapitalize( createPersonRequest.getApellido() ) );
            }
            if ( createPersonRequest.getSegundoApellido() != null ) {
                person.secondSurname( mapperHelper.stringCapitalize( createPersonRequest.getSegundoApellido() ) );
            }
            if ( createPersonRequest.getTipoDocumento() != null ) {
                person.typeDocument( mapperHelper.stringToTypeDocument( createPersonRequest.getTipoDocumento() ) );
            }
            if ( createPersonRequest.getDocumento() != null ) {
                person.document( createPersonRequest.getDocumento() );
            }
            if ( createPersonRequest.getEmail() != null ) {
                person.email( createPersonRequest.getEmail() );
            }
            if ( createPersonRequest.getId() != null ) {
                person.id( createPersonRequest.getId() );
            }
        }

        return person.build();
    }

    @Override
    public CreatePersonRequest personToCreatePersonRequest(Person person) {

        CreatePersonRequestBuilder<?, ?> createPersonRequest = CreatePersonRequest.builder();

        if ( person != null ) {
            if ( person.getId() != null ) {
                createPersonRequest.id( person.getId() );
            }
            if ( person.getFirstName() != null ) {
                createPersonRequest.nombre( person.getFirstName() );
            }
            if ( person.getSecondName() != null ) {
                createPersonRequest.segundoNombre( person.getSecondName() );
            }
            if ( person.getSurname() != null ) {
                createPersonRequest.apellido( person.getSurname() );
            }
            if ( person.getSecondSurname() != null ) {
                createPersonRequest.segundoApellido( person.getSecondSurname() );
            }
            if ( person.getTypeDocument() != null ) {
                createPersonRequest.tipoDocumento( mapperHelper.typeDocumentToString( person.getTypeDocument() ) );
            }
            if ( person.getDocument() != null ) {
                createPersonRequest.documento( person.getDocument() );
            }
            if ( person.getEmail() != null ) {
                createPersonRequest.email( person.getEmail() );
            }
        }

        return createPersonRequest.build();
    }

    @Override
    public Person updatePersonRequestToPerson(UpdatePersonRequest updatePersonRequest) {

        PersonBuilder<?, ?> person = Person.builder();

        if ( updatePersonRequest != null ) {
            if ( updatePersonRequest.getNombre() != null ) {
                person.firstName( mapperHelper.stringCapitalize( updatePersonRequest.getNombre() ) );
            }
            if ( updatePersonRequest.getSegundoNombre() != null ) {
                person.secondName( mapperHelper.stringCapitalize( updatePersonRequest.getSegundoNombre() ) );
            }
            if ( updatePersonRequest.getApellido() != null ) {
                person.surname( mapperHelper.stringCapitalize( updatePersonRequest.getApellido() ) );
            }
            if ( updatePersonRequest.getSegundoApellido() != null ) {
                person.secondSurname( mapperHelper.stringCapitalize( updatePersonRequest.getSegundoApellido() ) );
            }
            if ( updatePersonRequest.getTipoDocumento() != null ) {
                person.typeDocument( mapperHelper.stringToTypeDocument( updatePersonRequest.getTipoDocumento() ) );
            }
            if ( updatePersonRequest.getDocumento() != null ) {
                person.document( updatePersonRequest.getDocumento() );
            }
            if ( updatePersonRequest.getId() != null ) {
                person.id( updatePersonRequest.getId() );
            }
            if ( updatePersonRequest.getEmail() != null ) {
                person.email( updatePersonRequest.getEmail() );
            }
        }

        return person.build();
    }

    @Override
    public UpdatePersonRequest personToUpdatePersonRequest(Person person) {

        UpdatePersonRequestBuilder<?, ?> updatePersonRequest = UpdatePersonRequest.builder();

        if ( person != null ) {
            if ( person.getId() != null ) {
                updatePersonRequest.id( person.getId() );
            }
            if ( person.getFirstName() != null ) {
                updatePersonRequest.nombre( person.getFirstName() );
            }
            if ( person.getSecondName() != null ) {
                updatePersonRequest.segundoNombre( person.getSecondName() );
            }
            if ( person.getSurname() != null ) {
                updatePersonRequest.apellido( person.getSurname() );
            }
            if ( person.getSecondSurname() != null ) {
                updatePersonRequest.segundoApellido( person.getSecondSurname() );
            }
            if ( person.getTypeDocument() != null ) {
                updatePersonRequest.tipoDocumento( mapperHelper.typeDocumentToString( person.getTypeDocument() ) );
            }
            if ( person.getDocument() != null ) {
                updatePersonRequest.documento( person.getDocument() );
            }
            if ( person.getEmail() != null ) {
                updatePersonRequest.email( person.getEmail() );
            }
        }

        return updatePersonRequest.build();
    }

    @Override
    public List<CreatePersonRequest> listPersonToListCreatePersonRequest(List<Person> persons) {
        if ( persons == null ) {
            return new ArrayList<CreatePersonRequest>();
        }

        List<CreatePersonRequest> list = new ArrayList<CreatePersonRequest>( persons.size() );
        for ( Person person : persons ) {
            list.add( personToCreatePersonRequest( person ) );
        }

        return list;
    }
}
