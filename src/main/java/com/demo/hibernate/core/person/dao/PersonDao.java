package com.demo.hibernate.core.person.dao;

import com.demo.hibernate.core.person.entity.Person;

public interface PersonDao {

    Long save(Person person);
    Person findById(Long personId);
    Person update(Person person);
}
