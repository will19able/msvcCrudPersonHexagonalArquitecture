package com.wpolog.sprintcloud.mcsv.personas.infra.outputadapter.persistence.entity;

import com.wpolog.sprintcloud.mcsv.personas.infra.outputadapter.persistence.converter.TypeDocumentConverter;
import com.wpolog.sprintcloud.mcsv.personas.domain.TypeDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuperBuilder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PERSONAS")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "PRIMER_NOMBRE", nullable = false, length = 60)
    private String firstName;

    @Column(name = "SEGUNDO_NOMBRE", length = 60)
    private String secondName;

    @Column(name = "PRIMER_APELLIDO", nullable = false, length = 60)
    private String surname;

    @Column(name = "SEGUNDO_APELLIDO", length = 60)
    private String secondSurname;

    @Convert(converter = TypeDocumentConverter.class)
    @Column(name = "TIPO_DOCUMENTO", nullable = false, length = 2)
    private TypeDocument typeDocument;

    @Column(name = "DOCUMENTO", nullable = false, length = 16)
    private String document;

    @Column(name = "EMAIL", nullable = false, length = 60)
    private String email;

    @Transient
    private String imgUrl;


}
