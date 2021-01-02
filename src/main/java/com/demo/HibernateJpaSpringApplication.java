package com.demo;

import com.demo.hibernate.core.person.entity.Person;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.*;

@SpringBootApplication
@Log4j2
public class HibernateJpaSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = SpringApplication.run(HibernateJpaSpringApplication.class, args);
        SessionFactory sessionFactory = appContext.getBean(SessionFactory.class);
        Person person = createPersonEntity();
        try (Session session = sessionFactory.openSession()) {
        	session.getTransaction().begin();
            Long id = (Long) session.save(person);
            session.getTransaction().commit();
            log.info("Person saved with id {}", id);
        } catch (Exception exception) {
            log.info("Exception occurred {}", exception.getMessage());
        }
    }

    private static Person createPersonEntity() {
        Person person = new Person();
        person.setFirstName("Mehraj");
        person.setLastName("Malik");
        person.setLocalDate(LocalDate.now());
       person.setLocalDateTime(LocalDateTime.now());
        person.setDuration(Duration.ofHours(1L));
        person.setInstant(Instant.now());
        return person;
    }

}
