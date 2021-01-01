package com.demo.hibernate.core.person.controller;

import com.demo.hibernate.core.person.entity.Person;
import com.demo.hibernate.core.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persons")
@RequiredArgsConstructor
public class PersonController {

    private PersonService personService;

    @PostMapping
    public Person save(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping("/{personId}")
    public Person findById(@PathVariable Long personId) {
        return personService.findById(personId);
    }
}
