package com.demo.hibernate.core.person.dao;

import com.demo.hibernate.core.person.entity.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class PersonDaoImpl implements PersonDao {

    private SessionFactory sessionFactory;

    @Override
    public Long save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        Long personId;
        try {
            personId = (Long) session.save(person);
        } catch (Exception exception) {
            log.info("Exception occurred while saving person : {} ", exception.getMessage());
            throw exception;
        }
        return personId;
    }

    @Override
    public Person findById(Long personId) {
        Person person;
        try {
            Session session = sessionFactory.getCurrentSession();
            person = session.find(Person.class, personId);
        } catch (Exception exception) {
            log.info("Exception occurred while fetching person by Id {} : {} ", personId, exception.getMessage());
            throw exception;
        }
        return person;
    }

    @Override
    public Person update(Person person) {
        return null;
    }
}
