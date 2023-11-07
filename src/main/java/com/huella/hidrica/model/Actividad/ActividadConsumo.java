package com.huella.hidrica.model.Actividad;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ActividadConsumo {

    private Integer actividadConsumo;
    private Integer numeroActividad;
    private Float totalPromedioAguaCalculadaSistema;
    private Float totalPromedioLecheCalculadaSistema;
    private Float totalPromedioForrajeCalculadaSistema;
    private Float totalPromedioAgua;
    private Float totalPromedioLeche;
    private Float totalPromedioForraje;
    private Float totalConsumoDirecto;
    private Float totalConsumoServicio;
    private Float totalConsumoIndirecto;
    private Float totalAreaUsada;
    private Float totalConsumoAguaProduccion;
    private Float totalConsumoForrajeProduccion;
    private Float totalHuellaVerde;
    private Float totalHuellaAzul;
    private Float totalHuellaHidrica;
}
