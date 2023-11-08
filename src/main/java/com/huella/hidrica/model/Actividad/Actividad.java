package com.huella.hidrica.model.Actividad;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder(toBuilder = true)
public class Actividad {
    private Integer numeroActividad;
    private String codigoPotrero;
    private String tipoActividad;
    private String fechaInicio;
    private String fechaFinal;
    private String usuarioLoggeado;
    private ActividadConsumo actividadConsumo;
}
