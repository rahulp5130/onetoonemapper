package com.crossasyst.mapping.onetoonemapper.controller;

import com.crossasyst.mapping.onetoonemapper.entity.PersonEntity;
import com.crossasyst.mapping.onetoonemapper.mapper.PersonMapper;
import com.crossasyst.mapping.onetoonemapper.model.PersonRequest;
import com.crossasyst.mapping.onetoonemapper.model.PersonResponse;
import com.crossasyst.mapping.onetoonemapper.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Log4j2
@RestController
public class PersonController {
    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping("/persons")
    public ResponseEntity<PersonResponse>createPerson(@RequestBody PersonRequest personRequest){
        PersonResponse response = personService.createPerson(personRequest);
        log.info("creating persons");

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/persons")
    public List<PersonRequest>getAllPerson(){
        log.info("fetching persons");
       return personService.getAllPerson();
    }
    @DeleteMapping("/persons/{personId}")
    public ResponseEntity<Void> deletePersonById(@PathVariable Long personId){
        personService.deletePersonById(personId);
        log.info("deleting person");
        return ResponseEntity.ok().build();
    }
    @PutMapping("/persons/{personId}")
    public ResponseEntity<PersonRequest>updateById(@PathVariable Long personId,@RequestBody PersonRequest personRequest){
        PersonRequest personRequest1= personService.updateById(personId,personRequest);
        log.info("updating persons by personId");
       return new ResponseEntity<>(personRequest1,HttpStatus.OK);
    }
    @GetMapping("/persons/{personId}")
    public ResponseEntity<PersonRequest>getPersonById(@PathVariable Long personId){
        log.info("fetching person info by id"+personId);
        PersonRequest personRequest = personService.getPersonById(personId);
        return new ResponseEntity<>(personRequest,HttpStatus.OK);
    }

}
