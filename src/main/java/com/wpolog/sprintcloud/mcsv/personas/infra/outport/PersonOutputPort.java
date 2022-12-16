package com.wpolog.sprintcloud.mcsv.personas.infra.outport;

import com.wpolog.sprintcloud.mcsv.personas.domain.Person;
import com.wpolog.sprintcloud.mcsv.personas.domain.TypeDocument;

import java.util.List;
import java.util.Optional;

public interface PersonOutputPort {

    public Person save(Person person);

    public Optional<Person> findById(Long id);

    public Optional<Person> findByTypeDocumentAndDocument(TypeDocument typeDocument, String document);

    public Optional<List<Person>> findAll();

    public void delete( Long id );

}
