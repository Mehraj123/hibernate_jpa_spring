package com.demo.hibernate.core.controller;

import com.demo.hibernate.core.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persons")
@RequiredArgsConstructor
public class PersonController {
    private PersonService personService;
}
