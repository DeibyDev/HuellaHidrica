package com.huella.hidrica.repository.pasto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PastoDataRepository extends JpaRepository<PastoData, Integer> {

    Optional<PastoData> findByNombrePasto(String nombre);

}
