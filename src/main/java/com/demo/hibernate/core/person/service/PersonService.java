package com.demo.hibernate.core.person.service;

import com.demo.hibernate.core.person.dao.PersonDao;
import com.demo.hibernate.core.person.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private PersonDao personDao;

    public Person save(Person person) {
        Long personId = personDao.save(person);
        person.setId(personId);
        return person;
    }

    public Person findById(Long personId) {
        return personDao.findById(personId);
    }
}
