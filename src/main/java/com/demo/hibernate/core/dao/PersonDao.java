package com.demo.hibernate.core.dao;

import com.demo.hibernate.core.entity.Person;

public interface PersonDao {

    Long save(Person person);
    Person findById(Long personId);
    Person update(Person person);
}
