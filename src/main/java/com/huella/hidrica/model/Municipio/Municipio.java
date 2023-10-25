package com.huella.hidrica.model.Municipio;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Municipio {
    private Integer codigoMunicipio;
    private String nombreMunicipio;
}
