package com.crossasyst.mapping.onetoonemapper.service;

import com.crossasyst.mapping.onetoonemapper.entity.PersonEntity;
import com.crossasyst.mapping.onetoonemapper.mapper.PersonMapper;
import com.crossasyst.mapping.onetoonemapper.model.PersonRequest;
import com.crossasyst.mapping.onetoonemapper.model.PersonResponse;
import com.crossasyst.mapping.onetoonemapper.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@Log4j2
public class PersonService {
    private final PersonMapper personMapper;
    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }
    public PersonResponse createPerson(PersonRequest personRequest) {
        PersonEntity personEntity = personMapper.modelToPersonEntity(personRequest);
        personRepository.save(personEntity);
        PersonResponse personResponse = new PersonResponse();
        personResponse.setPersonId(personEntity.getPersonId());
        return personResponse;
    }
    @Scheduled(fixedRate = 5000)
    public List<PersonRequest> getAllPerson() {
        List<PersonEntity> personEntities = personRepository.findAll();
        List<PersonRequest> persons = personMapper.entityToModelList(personEntities);
        log.info("fetched all persons");
        return persons;
    }
    @CachePut(cacheNames = "persons", key = "#id")
    public PersonRequest updateById(Long personId, PersonRequest personRequest) {
        PersonEntity personEntity = personRepository.getOne(personId);
        PersonEntity personEntity1= personMapper.modelToPersonEntity(personRequest);
        personEntity1.setPersonId(personId);
        personEntity1.getAddress().setAddressId(personEntity.getAddress().getAddressId());
        personRepository.save(personEntity1);
        PersonRequest personRequest1 = personMapper.entityToPersonModel(personEntity1);
        log.info("updated person"+personId);
        return personRequest1;
    }
    @Cacheable(cacheNames = "persons")
    public PersonRequest getPersonById(Long personId) {
        PersonEntity personEntity= personRepository.findById(personId).get();
        PersonRequest personRequest= personMapper.entityToPersonModel(personEntity);
        log.info("fetching success person info by"+personId);
         return personRequest;
    }
    @CacheEvict(cacheNames = "persons")
    public void deletePersonById(Long personId) {
       personRepository.deleteById(personId);
    }
}
