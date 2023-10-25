package com.huella.hidrica.repository.municipio;

import com.huella.hidrica.repository.departamento.DepartamentoData;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "Municipios")
@Entity
public class MunicipioData {

    @Id
    @Column(name = "id_municipio")
    private Integer codigoMunicipio;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "id_departamento")
    private Integer codigoDepartamento;


}
