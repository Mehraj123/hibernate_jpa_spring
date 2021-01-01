package com.demo.hibernate.core.person.controller;

import com.demo.hibernate.core.person.service.PersonDto;
import com.demo.hibernate.core.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public PersonDto save(@RequestBody PersonDto personDto) {
        return personService.save(personDto);
    }

    @GetMapping("/{personId}")
    public PersonDto findById(@PathVariable Long personId) {
        return personService.findById(personId);
    }

    @PutMapping
    public PersonDto update(@RequestBody PersonDto personDto){
       return personService.update(personDto);
    }
}
