package com.wpolog.sprintcloud.mcsv.personas.infra.inputadapter.http.person;

import com.wpolog.sprintcloud.mcsv.personas.domain.Person;
import com.wpolog.sprintcloud.mcsv.personas.infra.inputadapter.http.person.dto.CreatePersonRequest;
import com.wpolog.sprintcloud.mcsv.personas.infra.inputadapter.http.person.dto.UpdatePersonRequest;
import com.wpolog.sprintcloud.mcsv.personas.infra.inputadapter.http.person.mapper.PersonMapper;
import com.wpolog.sprintcloud.mcsv.personas.infra.inputadapter.http.responsehandler.ResponseHandler;
import com.wpolog.sprintcloud.mcsv.personas.infra.inputport.http.PersonHttpInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/persona")
public class PersonaController {

    @Autowired
    PersonHttpInputPort personHttpInputPort;

    @PostMapping(value = "create", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@Valid @RequestBody CreatePersonRequest createPersonRequest) {
        Person savedPerson = personHttpInputPort.createPerson(PersonMapper.INSTANCE.createPersonRequestToPerson(createPersonRequest));
        return ResponseHandler.generateResponse(ResponseHandler.MESSAGE_SUCCEFULY, HttpStatus.OK,
                PersonMapper.INSTANCE.personToCreatePersonRequest(savedPerson));
    }

    @PutMapping(value = "update", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@Valid @RequestBody UpdatePersonRequest updatePersonRequest) {
        Person updatedPerson = personHttpInputPort.updatePerson(PersonMapper.INSTANCE.updatePersonRequestToPerson(updatePersonRequest));
        return ResponseHandler.generateResponse(ResponseHandler.MESSAGE_SUCCEFULY, HttpStatus.OK,
                PersonMapper.INSTANCE.personToUpdatePersonRequest(updatedPerson));
    }

    @GetMapping(value = "get", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> get(@RequestParam Long personaId ) {
        return ResponseHandler.generateResponse(ResponseHandler.MESSAGE_SUCCEFULY, HttpStatus.OK,
                PersonMapper.INSTANCE.personToCreatePersonRequest(personHttpInputPort.findById(personaId)));
    }

    @GetMapping(value = "getall", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAll() {
        return ResponseHandler.generateResponse(ResponseHandler.MESSAGE_SUCCEFULY, HttpStatus.OK,
                new PageImpl<>(PersonMapper.INSTANCE.listPersonToListCreatePersonRequest(personHttpInputPort.findAll())));
    }

    @DeleteMapping(value = "delete", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delete(@RequestParam Long personaId ) {
        return ResponseHandler.generateResponse(ResponseHandler.MESSAGE_SUCCEFULY, HttpStatus.OK,
                PersonMapper.INSTANCE.personToCreatePersonRequest(personHttpInputPort.deletePerson(personaId)));
    }
}
