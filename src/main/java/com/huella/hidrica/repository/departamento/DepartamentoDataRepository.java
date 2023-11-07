package com.huella.hidrica.repository.departamento;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface DepartamentoDataRepository  extends JpaRepository<DepartamentoData,String> {
    @Query(value = "select  d.* , m.*  from departamentos d , municipios m " +
            "where d.id_departamento=m.id_departamento and d.id_departamento = '25'", nativeQuery = true)
    DepartamentoData findByIdCodigoDepartamento(@Param("codigoDepartamento") Integer codigoDepartamento);
}
