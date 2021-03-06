package com.demo.hibernate.core.person.dao;

import com.demo.hibernate.core.person.entity.Person;
import com.demo.hibernate.core.person.dto.PersonDto;

public interface PersonDao {

    Person save(Person person);

    Person findById(Long personId);

    Person update(PersonDto personDto);

    Long delete(Long personId);
}
