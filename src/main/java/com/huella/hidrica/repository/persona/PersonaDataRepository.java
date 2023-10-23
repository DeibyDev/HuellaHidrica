package com.huella.hidrica.repository.persona;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PersonaDataRepository extends JpaRepository<PersonaData,Integer> {

    Optional<PersonaData> findByTipoDocumentoAndNumeroDocumento(String tipoDocumento , Integer numeroDocumento);

}
