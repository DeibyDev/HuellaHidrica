package com.huella.hidrica.repository.potrero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PotreroDataRepository extends JpaRepository<PotreroData, String> {

    Optional<PotreroData> findByNombrePotreroAndCodigoFinca(String nombrePotrero, String numeroFinca);

    List<PotreroData> findByCodigoFinca(String numeroFinca);


}
