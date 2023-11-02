package com.huella.hidrica.repository.Actividad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ActividadDataRepository extends JpaRepository<ActividadData, Integer> {
    @Query(
            value = "SELECT * FROM actividad c WHERE c.fecha_fin BETWEEN TO_DATE(?1, 'YYYY-MM-DD') AND TO_DATE(?2, 'YYYY-MM-DD') AND cod_potrero = ?3",
            nativeQuery = true)
    List<ActividadData> buscarPorFechaYCodigoPotrero(String fechaInicio, String fechaFin, String codigoPotrero);

    List<ActividadData> findByCodigoPotrero(String codigoPotrero);
}
