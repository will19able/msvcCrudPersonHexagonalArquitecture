package com.wpolog.sprintcloud.mcsv.personas.infra.outputadapter.persistence;

import com.wpolog.sprintcloud.mcsv.personas.domain.Person;
import com.wpolog.sprintcloud.mcsv.personas.domain.TypeDocument;
import com.wpolog.sprintcloud.mcsv.personas.infra.outport.PersonOutputPort;
import com.wpolog.sprintcloud.mcsv.personas.infra.outputadapter.persistence.entity.PersonEntity;
import com.wpolog.sprintcloud.mcsv.personas.infra.outputadapter.persistence.mapper.PersonEntityMapper;
import com.wpolog.sprintcloud.mcsv.personas.infra.outputadapter.persistence.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class    PersonPersistenceOutputAdapter implements PersonOutputPort {

    @Autowired
    PersonaRepository personaRepository;


    @Override
    public Person save(Person person) {
        PersonEntity personEntity = personaRepository.save(PersonEntityMapper
                .INSTANCE.personToPersonEntity(person));
        return PersonEntityMapper.INSTANCE.personEntityToPerson(personEntity);
    }

    @Override
    public Optional<Person> findById(Long id) {
        Optional<PersonEntity> personaEntityOptional = personaRepository.findById(id);
        if (personaEntityOptional.isPresent()){
            return Optional.of(PersonEntityMapper.INSTANCE.personEntityToPerson(personaEntityOptional.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Person> findByTypeDocumentAndDocument(TypeDocument typeDocument, String document) {
        Optional<PersonEntity> personaEntityOptional = personaRepository.findByTypeDocumentAndDocument(typeDocument, document);
        if (personaEntityOptional.isPresent()){
            return Optional.of(PersonEntityMapper.INSTANCE.personEntityToPerson(personaEntityOptional.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<Person>> findAll() {
        List<PersonEntity> personaEntities = personaRepository.findAll();
        if (personaEntities.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(PersonEntityMapper.INSTANCE.listPersonEntityTolistPerson(personaEntities));
    }

    @Override
    public void delete(Long idPersona) {
        personaRepository.deleteById(idPersona);
    }
}
