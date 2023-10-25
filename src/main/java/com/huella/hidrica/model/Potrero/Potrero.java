package com.huella.hidrica.model.Potrero;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Potrero {
    private String codigoPotrero;
    private String nombrePotrero;
    private Float areaPotrero;
    private Float capacidadMaximaForraje;
    private Float capacidadMaximaAgua;
    private Integer cupoMaximoAnimales;
    private Integer codigoPasto;
    private Integer codigoFinca;
}
