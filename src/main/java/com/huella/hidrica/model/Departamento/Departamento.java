package com.huella.hidrica.model.Departamento;

import com.huella.hidrica.model.Municipio.Municipio;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder(toBuilder = true)
public class Departamento {
    private Integer codigoDepartamento;
    private String nombreDepartamento;
    private List<Municipio> listaMunicipios;
}
