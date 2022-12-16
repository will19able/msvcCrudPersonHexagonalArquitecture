package com.wpolog.sprintcloud.mcsv.personas.aplication;

import com.wpolog.sprintcloud.mcsv.personas.domain.Person;
import com.wpolog.sprintcloud.mcsv.personas.domain.TypeDocument;
import com.wpolog.sprintcloud.mcsv.personas.domain.exeption.BusinessException;
import com.wpolog.sprintcloud.mcsv.personas.domain.exeption.CodeError;
import com.wpolog.sprintcloud.mcsv.personas.infra.inputport.http.PersonHttpInputPort;
import com.wpolog.sprintcloud.mcsv.personas.infra.outport.PersonOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class PersonHttpUsesCases implements PersonHttpInputPort {

    @Autowired
    PersonOutputPort personOutputPort;


    @Override
    @Transactional
    public Person createPerson(Person person) {
        person.setId(null);
        this.validateTypeDocumentIsNd(person.getTypeDocument());
        this.validateDontExistPerson(this.findByTypeDocumentAndDocument(person.getTypeDocument(), person.getDocument()));
        return  personOutputPort.save(person);
    }

    @Override
    @Transactional
    public Person updatePerson(Person person) {
        this.validateTypeDocumentIsNd(person.getTypeDocument());
        Person consultedPerson = this.findById(person.getId());
        this.validateExistPerson(consultedPerson);
        consultedPerson.setFirstName(person.getFirstName());
        consultedPerson.setSecondName(person.getSecondName());
        consultedPerson.setSurname(person.getSurname());
        consultedPerson.setSecondSurname(person.getSecondSurname());
        consultedPerson.setTypeDocument(person.getTypeDocument());
        consultedPerson.setDocument(person.getDocument());
        consultedPerson.setEmail(person.getEmail());
        return personOutputPort.save(consultedPerson);
    }

    @Override
    @Transactional(readOnly = true)
    public Person findById(Long idPersona) {
        Optional<Person> personaOptional = personOutputPort.findById(idPersona);
        return personaOptional.isPresent() ? personaOptional.get() : null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> findAll() {
        Optional<List<Person>> personasOptional = personOutputPort.findAll();
        return personasOptional.isPresent() ? personasOptional.get() : null;
    }

    @Override
    @Transactional
    public Person deletePerson(Long idPersona) {
        Optional<Person> personaOptional = personOutputPort.findById(idPersona);
        if (personaOptional.isPresent()){
            personOutputPort.delete(idPersona);
            return personaOptional.get();
        }
        return null;
    }

    private void validateDontExistPerson(Person person){
        if(nonNull(person)){
            throw new BusinessException(CodeError.REGISTERED_PERSON.getDescription(), CodeError.REGISTERED_PERSON.getId());
        }
    }

    private void validateTypeDocumentIsNd(TypeDocument typeDocument){
        if(TypeDocument.typeDocumentIn(TypeDocument.ND, typeDocument)){
            throw new BusinessException(CodeError.TYPE_DOCUMENT_INVALID.getDescription(), CodeError.TYPE_DOCUMENT_INVALID.getId());
        }
    }

    private void validateExistPerson(Person person){
        if(isNull(person)){
            throw new BusinessException(CodeError.DONT_REGISTERED_PERSON.getDescription(), CodeError.DONT_REGISTERED_PERSON.getId());
        }
    }

    private Person findByTypeDocumentAndDocument(TypeDocument typeDocument, String document){
        Optional<Person> personaOptional = personOutputPort.findByTypeDocumentAndDocument(typeDocument, document);
        return personaOptional.isPresent() ? personaOptional.get() : null;
    }
}
