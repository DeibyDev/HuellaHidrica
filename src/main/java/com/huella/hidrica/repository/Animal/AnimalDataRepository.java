package com.huella.hidrica.repository.Animal;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnimalDataRepository extends JpaRepository<AnimalData,String> {

    List<AnimalData> findByCodigoPotrero (String codigoPotrero);
    Optional<AnimalData> findByCodigoPotreroAndCodigoAnimal(String codigoPotrero, String numeroCotral);
}
