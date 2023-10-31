package com.huella.hidrica.repository.Configuracion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConfiguracionDataRepository extends JpaRepository<ConfiguracionData,Integer> {
    @Query(
            value = "select * from configuraciones c where inicio <=?1 " +
                    "and fin >= ?1",
            nativeQuery = true)
    ConfiguracionData findUserByEdad(Integer edadAnimal);

    @Query(
            value = "select * from configuraciones c where numero_partos_inicio <=?1 " +
                    "and numero_partos_final >= ?1",
            nativeQuery = true)
    ConfiguracionData findUserByParto(Integer numeroPartos);

}
