package com.wpolog.sprintcloud.mcsv.personas.domain.exeption;

public class BusinessException extends RuntimeException{

    public String codeError;
    public BusinessException(String message, String codeError) {
        super(message);
        this.codeError = codeError;
    }

}
