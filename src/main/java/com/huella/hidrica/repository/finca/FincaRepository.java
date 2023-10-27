package com.huella.hidrica.repository.finca;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FincaRepository extends JpaRepository<FincaData,String> {
    List<FincaData> findByIdPersona(String numeroPropietario);
}
