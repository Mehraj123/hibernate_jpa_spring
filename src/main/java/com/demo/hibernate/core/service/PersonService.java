package com.demo.hibernate.core.service;

import com.demo.hibernate.core.dao.PersonDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
    private PersonDao personDao;
}
