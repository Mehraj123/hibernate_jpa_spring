package com.demo.hibernate.core.person.dao;

import com.demo.hibernate.core.person.entity.Person;
import com.demo.hibernate.core.person.service.PersonDto;

public interface PersonDao {

    Long save(Person person);

    Person findById(Long personId);

    Person update(PersonDto personDto);
}
