package com.huella.hidrica.model.Configuraciones;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Configuracion {
    private Integer codigoConfiguracion;
    private Integer mesInicio;
    private Integer mesFin;
    private Integer numeroPartosInicio;
    private Integer numeroPartosFin;
    private String peso;
    private Float porcentaje;
    private Float porcentajeForraje;
    private Float porcentajeAgua;
    private String etapa;
}
