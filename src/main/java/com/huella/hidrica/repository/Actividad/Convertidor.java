package com.huella.hidrica.repository.Actividad;

import com.huella.hidrica.model.Actividad.Actividad;
import com.huella.hidrica.model.Actividad.ActividadConsumo;

import java.util.List;
import java.util.stream.Collectors;

public class Convertidor {

    public static Actividad convertidorActividadDataADominio(ActividadData data){
             return Actividad
                     .builder()
                     .fechaInicio(data.getFechaInicio())
                     .numeroActividad(data.getNumeroActividad())
                     .tipoActividad(data.getTipoActividad())
                     .fechaFinal(data.getFechaFin())
                     .usuarioLoggeado(data.getUsuario())
                     .actividadConsumo(convertidorActividadConsumoADominio(data.getActividaConsumoData()))
                     .build();
    }

    public static ActividadConsumo convertidorActividadConsumoADominio(ActividadConsumoData data){
        return ActividadConsumo.builder()
                .totalPromedioAgua(data.getPromedioAguaUsuario())
                .totalPromedioForraje(data.getPromedioForrajeUsuario())
                .totalPromedioLeche(data.getPromedioLecheUsuario())
                .totalPromedioForrajeCalculadaSistema(data.getPromedioForrajeSistema())
                .totalPromedioLecheCalculadaSistema(data.getPromedioLecheSistema())
                .totalPromedioAguaCalculadaSistema(data.getPromedioAguaSistema())
                .totalAreaUsada(data.getTotalAreaUtilizada())
                .totalConsumoAguaProduccion(data.getTotalConsumoAguaProduccion())
                .totalConsumoDirecto(data.getTotalConsumoIndirecto())
                .totalConsumoIndirecto(data.getTotalConsumoIndirecto())
                .totalConsumoServicio(data.getTotalConsumoServicio())
                .numeroActividad(data.getCodigoActividad())
                .actividadConsumo(data.getNumeroActividadConsumo())
                .totalConsumoForrajeProduccion(data.getTotalConsumoForrajeProduccion())
                .totalHuellaAzul(data.getHuellaAzul())
                .totalHuellaVerde(data.getHuellaVerde())
                .totalHuellaHidrica(data.getHuellaHidrica())
                .build();
    }



    public static ActividadConsumoData convertidorDominioAData(ActividadConsumo actividadConsumo){
        ActividadConsumoData actividadData = new ActividadConsumoData();
        actividadData.setPromedioAguaSistema(actividadConsumo.getTotalPromedioAguaCalculadaSistema());
        actividadData.setPromedioForrajeSistema(actividadConsumo.getTotalPromedioForrajeCalculadaSistema());
        actividadData.setPromedioLecheSistema(actividadConsumo.getTotalPromedioLecheCalculadaSistema());
        actividadData.setPromedioLecheUsuario(actividadConsumo.getTotalPromedioLeche());
        actividadData.setPromedioForrajeUsuario(actividadConsumo.getTotalPromedioForraje());
        actividadData.setPromedioAguaUsuario(actividadConsumo.getTotalPromedioAgua());
        actividadData.setCodigoActividad(actividadConsumo.getNumeroActividad());
        actividadData.setNumeroActividadConsumo(actividadConsumo.getActividadConsumo());
        actividadData.setTotalAreaUtilizada(actividadConsumo.getTotalAreaUsada());
        actividadData.setTotalConsumodirecto(actividadConsumo.getTotalConsumoDirecto());
        actividadData.setTotalConsumoIndirecto(actividadConsumo.getTotalConsumoIndirecto());
        actividadData.setTotalConsumoServicio(actividadConsumo.getTotalConsumoServicio());
        actividadData.setTotalConsumoForrajeProduccion(actividadConsumo.getTotalConsumoForrajeProduccion());
        actividadData.setTotalConsumoAguaProduccion(actividadConsumo.getTotalConsumoAguaProduccion());
        actividadData.setHuellaAzul(actividadConsumo.getTotalHuellaAzul());
        actividadData.setHuellaHidrica(actividadConsumo.getTotalHuellaHidrica());
        actividadData.setHuellaVerde(actividadConsumo.getTotalHuellaVerde());
        return actividadData;
    }


    public static ActividadData convertidorDeDominioAData(Actividad actividad){
        ActividadData actividadData = new ActividadData();
        actividadData.setNumeroActividad(actividad.getNumeroActividad());
        actividadData.setFechaFin(actividad.getFechaFinal());
        actividadData.setFechaInicio(actividad.getFechaInicio());
        actividadData.setTipoActividad(actividad.getTipoActividad());
        actividadData.setCodigoPotrero(actividad.getCodigoPotrero());
        actividadData.setUsuario(actividad.getUsuarioLoggeado());
        actividadData.setActividaConsumoData(convertidorDominioAData(actividad.getActividadConsumo()));
        return actividadData;
    }

    public static List<Actividad> convertirADataList(List<ActividadData> actividadData){
        return actividadData.stream().map(Convertidor::convertidorActividadDataADominio)
                .collect(Collectors.toList());
    }

}
