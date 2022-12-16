package com.wpolog.sprintcloud.mcsv.personas.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Getter
public enum TypeDocument {

    CEDULA_CIUDADANIA(TypeDocument.CEDULA_CIUDADANIA_CODE, "Cédula de ciudadanía"),
    CEDULA_DE_EXTRANJERIA(TypeDocument.CEDULA_EXTRANJERIA_CODE, "Cédula de extranjería"),
    PASAPORTE(TypeDocument.PASAPORTE_CODE, "Pasaporte"),
    NIT(TypeDocument.NIT_CODE, "NIT"),
    CARNE_DIPLOMATICO(TypeDocument.CARNE_DIPLOMATICO_CODE, "Carné diplomático"),
    PE(TypeDocument.PE_CODE, "Permiso especial de permanencia"),
    SALVOCONDUCTO(TypeDocument.SALVOCONDUCTO_CODE, "Salvoconducto de permanencia"),
    ND(TypeDocument.ND_CODE, "No Definido");

    public static final String CEDULA_CIUDADANIA_CODE = "CC";
    public static final String CEDULA_EXTRANJERIA_CODE = "CE";
    public static final String PASAPORTE_CODE = "PA";
    public static final String CARNE_DIPLOMATICO_CODE = "CD";
    public static final String NIT_CODE = "NI";
    public static final String PE_CODE = "PE";
    public static final String SALVOCONDUCTO_CODE = "SC";
    public static final String ND_CODE = "ND";

    private static final Map<String, TypeDocument> BY_ID = new HashMap<>();
    private static final List<String> LIST_STRING;


    private final String id;
    private final String name;
    private final String description;

    static {
        for (TypeDocument e : values()) {
            BY_ID.put(e.id, e);
        }
        LIST_STRING = new ArrayList<>(BY_ID.keySet());
    }

    TypeDocument(String id, String description) {
        this.id = id;
        this.name = name();
        this.description = description;
    }

    public static TypeDocument findByPrimaryKey(String id) {
        return id != null ? Optional.ofNullable(BY_ID.get(id)).orElse(ND) : ND;
    }


    public static boolean typeDocumentIn(TypeDocument tipoDocumento, TypeDocument... tipoDocumentos) {
        if (tipoDocumentos != null && tipoDocumento != null) {
            return Arrays.stream(tipoDocumentos).anyMatch(element -> element.equals(tipoDocumento));
        }
        return false;
    }


}

