package com.wpolog.sprintcloud.mcsv.personas.infra.inputadapter.http.person.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PUBLIC)
public class UpdatePersonRequest {

    @NotNull(message = "El id de la persona es obligatorio")
    Long id;

    @NotEmpty(message = "El nombre es obligatorio")
    String nombre;

    String segundoNombre;

    @NotEmpty(message = "El primer apellido es obligatorio")
    String apellido;

    @NotEmpty(message = "El segundo apellido es obligatorio")
    String segundoApellido;

    @NotEmpty(message = "El tipo de documento es obligatorio")
    String tipoDocumento;

    @NotEmpty(message = "El documento es obligatorio")
    String documento;

    @NotEmpty(message = "El sexo es obligatorio")
    @Email(message = "El formato del correo es incorrecto")
    String email;

}
