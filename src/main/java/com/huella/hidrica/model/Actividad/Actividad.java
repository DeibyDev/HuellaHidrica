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
    private Float totalPromedioAguaCalculadaSistema;
    private Float totalPromedioLecheCalculadaSistema;
    private Float totalPromedioForrajeCalculadaSistema;
    private Float totalPromedioAgua;
    private Float totalPromedioLeche;
    private Float totalPromedioForraje;
    private Date fechaInicio;
    private Date fechaFinal;
    private Boolean lavoCantinas;
    private Boolean realizoRiego;
    private String usuarioLoggeado;
}
