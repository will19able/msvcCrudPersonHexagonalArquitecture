package com.wpolog.sprintcloud.mcsv.personas.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private Long id;

    private String firstName;

    private String secondName;

    private String surname;

    private String secondSurname;

    private TypeDocument typeDocument;

    private String document;

    private String email;


}
