package com.wpolog.sprintcloud.mcsv.personas.infra.inputadapter.http.person.mapper;

import com.wpolog.sprintcloud.mcsv.personas.domain.TypeDocument;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@NoArgsConstructor
@Component
public class MapperHelper {

    @Named("stringCapitalize")
    public String stringCapitalize(String value) {
        return  String.join(" ",
                        Arrays.stream(value.split(" "))
                                .filter(StringUtils::isNotBlank)
                                .map( word -> StringUtils.capitalize(word.toLowerCase())).collect(Collectors.toList()))
                .replace(" ,", ",")
                .replace(" ;", ";")
                .replace(" .", ".");
    }

    public TypeDocument stringToTypeDocument(String value){
        return isNull(value) ? null : TypeDocument.findByPrimaryKey(value);
    }

    public String typeDocumentToString(TypeDocument value){
        return isNull(value) ? "" : value.getId().concat("-").concat(value.getDescription());
    }

}
