package com.wpolog.sprintcloud.mcsv.personas.infra.outputadapter.persistence.converter;


import com.wpolog.sprintcloud.mcsv.personas.domain.TypeDocument;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TypeDocumentConverter implements AttributeConverter<TypeDocument, String> {

    @Override
    public String convertToDatabaseColumn(TypeDocument attribute) {
        if (attribute != null) {
            return attribute.getId();
        }
        return null;
    }

    @Override
    public TypeDocument convertToEntityAttribute(String dbData) {
        return dbData != null ? TypeDocument.findByPrimaryKey(dbData) : null;

    }
}

