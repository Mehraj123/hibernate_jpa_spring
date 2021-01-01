package com.demo.hibernate.core.person.service;

import com.demo.hibernate.core.person.dao.PersonDao;
import com.demo.hibernate.core.person.dto.PersonDto;
import com.demo.hibernate.core.person.entity.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PersonService {

    private final PersonDao personDao;

    public PersonDto save(PersonDto personDto) {
        Person personEntity = convertToPersonEntity(personDto);
        Person person = personDao.save(personEntity);
        return convertToPersonDto(person);
    }

    public PersonDto findById(Long personId) {
        Person person = personDao.findById(personId);
        if (person == null)
            return null;
        return convertToPersonDto(person);
    }

    public PersonDto update(PersonDto personDto) {
        Person updatedPerson = personDao.update(personDto);
        return convertToPersonDto(updatedPerson);
    }

    public Long delete(Long personId) {
        return personDao.delete(personId);
    }

    private Person convertToPersonEntity(PersonDto personDto) {
        Person personEntity = new Person();
        personEntity.setFirstName(personDto.getFirstName());
        personEntity.setLastName(personDto.getLastName());
        return personEntity;
    }

    private PersonDto convertToPersonDto(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        return personDto;
    }


}
