package com.huella.hidrica.model.Pasto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ConfiguracionConstantes {
    private Integer codigoConfiguracion;
    private String nombre;
    private String descripcion;
    private Float valor;
    private Integer codigoPasto;
}
