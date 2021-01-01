package com.demo.hibernate.core.person.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PersonDto {
    private Long id;
    private String firstName;
    private String lastName;
}
