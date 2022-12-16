package com.wpolog.sprintcloud.mcsv.personas.infra.outputadapter.persistence.repository;

import com.wpolog.sprintcloud.mcsv.personas.domain.TypeDocument;
import com.wpolog.sprintcloud.mcsv.personas.infra.outputadapter.persistence.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<PersonEntity, Long> {

    Optional<PersonEntity> findByTypeDocumentAndDocument(TypeDocument typeDocument, String document);

    void deleteById(Long idPersona);
}
