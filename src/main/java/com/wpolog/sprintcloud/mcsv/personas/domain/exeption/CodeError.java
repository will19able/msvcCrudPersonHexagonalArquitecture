package com.wpolog.sprintcloud.mcsv.personas.domain.exeption;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public enum CodeError {

    DEFAULT_SYSTEM_ERROR(CodeError.DEFAULT_SYSTEM_ERROR_CODE, "Generic Error."),
    REGISTERED_PERSON(CodeError.REGISTERED_PERSON_CODE, "La persona ya se encuentra registrada en el sistema."),
    DONT_REGISTERED_PERSON(CodeError.DONT_REGISTERED_PERSON_CODE, "La persona no se encuentra registrada en el sistema."),

    TYPE_DOCUMENT_INVALID(CodeError.TYPE_DOCUMENT_INVALID_CODE, "El tipo de documento ingresado es inválido."),
    ND(CodeError.ND_CODE, "No Definido");

    public static final String DEFAULT_SYSTEM_ERROR_CODE = "RTP001";
    public static final String REGISTERED_PERSON_CODE = "RTP002";
    public static final String DONT_REGISTERED_PERSON_CODE = "RTP003";
    public static final String TYPE_DOCUMENT_INVALID_CODE = "RTP004";
    public static final String ND_CODE = "ND";

    private static final Map<String, CodeError> BY_ID = new HashMap<>();
    private static final List<String> LIST_STRING;


    private final String id;
    private final String name;
    private final String description;

    static {
        for (CodeError e : values()) {
            BY_ID.put(e.id, e);
        }
        LIST_STRING = new ArrayList<>(BY_ID.keySet());
    }

    CodeError(String id, String description) {
        this.id = id;
        this.name = name();
        this.description = description;
    }

    public static CodeError findByPrimaryKey(String id) {
        return id != null ? BY_ID.get(id) : ND;
    }




}

