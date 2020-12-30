package com.demo.hibernate.core.dao;

import com.demo.hibernate.core.entity.Person;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PersonDaoImpl implements PersonDao{
    private SessionFactory sessionFactory;


    @Override
    public Long save(Person person) {
        return null;
    }

    @Override
    public Person findById(Long personId) {
        return null;
    }

    @Override
    public Person update(Person person) {
        return null;
    }
}
