package com.demo.hibernate.core.person.dao;

import com.demo.hibernate.core.common.BaseException;
import com.demo.hibernate.core.common.ErrorCode;
import com.demo.hibernate.core.person.dto.PersonDto;
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

    private final SessionFactory sessionFactory;

    @Override
    public Person save(Person person) {
        Person savedPerson;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Long personId = (Long) session.save(person);
            session.getTransaction().commit();
            // Session is first level Cache
            // So, if we load the entity which is just saved it will not look-up into DB.
            // Rather, just fetch is from Session because Hibernate saved the entity in Session as well.
            // But from the same session only, if we open a new session and try to load
            // if will look-up into DB.
            savedPerson = session.find(Person.class, personId);
            log.info("person saved {} with id {} ", person, personId);
        } catch (Exception exception) {
            log.info("Exception occurred while saving person {} : {} ", person, exception.getMessage());
            throw new BaseException(ErrorCode.ENTITY_SAVE_FAILED);
        }
        return savedPerson;
    }

    @Override
    public Person findById(Long personId) {
        Person person;
        try (Session session = sessionFactory.openSession()) {
            person = session.find(Person.class, personId);
            if (person == null) {
                log.info("Person not found by id {} ", personId);
                throw new BaseException(ErrorCode.ENTITY_NOT_FOUND);
            }
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            log.info("Exception occurred while fetching person by Id {} : {} ", personId, exception.getMessage());
            throw new BaseException(ErrorCode.SERVER_FAILED);
        }
        return person;
    }

    @Override
    public Person update(PersonDto personDto) {
        try (Session session = sessionFactory.openSession()) {
            Person personById = findById(personDto.getId());
            Person person = updatePerson(personById, personDto);
            session.beginTransaction();
            Person updatedPerson = (Person) session.merge(person);
            session.getTransaction().commit();
            log.info("Updated person with id {} to {}", personDto.getId(), updatedPerson);
            return updatedPerson;
        } catch (BaseException baseException) {
            throw baseException;
        } catch (Exception exception) {
            log.info("Exception occurred while fetching person by Id {} : {} ", personDto.getId(), exception.getMessage());
            throw new BaseException(ErrorCode.SERVER_FAILED);
        }
    }

    @Override
    public Long delete(Long personId) {
        try (Session session = sessionFactory.openSession()) {
            Person person = findById(personId);
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
            log.info("Person deleted with id {}", personId);
            return personId;
        } catch (Exception exception) {
            log.info("Exception occurred while deleting person by Id {} : {} ", personId, exception.getMessage());
            throw new BaseException(ErrorCode.SERVER_FAILED);
        }
    }

    private Person updatePerson(Person person, PersonDto personDto) {
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        return person;
    }
}
