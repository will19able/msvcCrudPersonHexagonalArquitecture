package com.wpolog.sprintcloud.mcsv.personas.infra.inputport.http;

import com.wpolog.sprintcloud.mcsv.personas.domain.Person;

import java.util.List;

public interface PersonHttpInputPort {

    public Person createPerson(Person person);
    public Person updatePerson(Person person);

    public Person findById(Long idPersona);

    public List<Person> findAll();

    public Person   deletePerson(Long idPersona);

}
