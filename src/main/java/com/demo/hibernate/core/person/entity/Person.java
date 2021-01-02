package com.demo.hibernate.core.person.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.*;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate localDate;
    //private LocalTime localTime;
    private LocalDateTime localDateTime;
    private Duration duration;
    private Instant instant;
}
