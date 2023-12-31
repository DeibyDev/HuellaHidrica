package com.huella.hidrica.repository.Actividad;

import com.huella.hidrica.model.Actividad.Actividad;
import com.huella.hidrica.model.Actividad.ActividadConsumo;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Convertidor {

    public static Actividad convertidorActividadDataADominio(ActividadData data){
             return Actividad
                     .builder()
                     .fechaInicio(convertidorDeFechaDto(data.getFechaInicio()))
                     .numeroActividad(data.getNumeroActividad())
                     .tipoActividad(data.getTipoActividad())
                     .fechaFinal(convertidorDeFechaDto(data.getFechaFin()))
                     .usuarioLoggeado(data.getUsuario())
                     .codigoPotrero(data.getCodigoPotrero())
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



    public static ActividadConsumoData convertidorDominioAData(ActividadConsumo actividadConsumo, Integer numeroActividad){
        ActividadConsumoData actividadData = new ActividadConsumoData();
        actividadData.setPromedioAguaSistema(actividadConsumo.getTotalPromedioAguaCalculadaSistema());
        actividadData.setPromedioForrajeSistema(actividadConsumo.getTotalPromedioForrajeCalculadaSistema());
        actividadData.setPromedioLecheSistema(actividadConsumo.getTotalPromedioLecheCalculadaSistema());
        actividadData.setPromedioLecheUsuario(actividadConsumo.getTotalPromedioLeche());
        actividadData.setPromedioForrajeUsuario(actividadConsumo.getTotalPromedioForraje());
        actividadData.setPromedioAguaUsuario(actividadConsumo.getTotalPromedioAgua());
        actividadData.setCodigoActividad(actividadConsumo.getNumeroActividad());
        actividadData.setNumeroActividadConsumo(numeroActividad);
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
        actividadData.setFechaFin(convertidorDeFecha(actividad.getFechaFinal()));
        actividadData.setFechaInicio(convertidorDeFecha(actividad.getFechaInicio()));
        actividadData.setTipoActividad(actividad.getTipoActividad());
        actividadData.setCodigoPotrero(actividad.getCodigoPotrero());
        actividadData.setUsuario(actividad.getUsuarioLoggeado());
        actividadData.setActividaConsumoData(convertidorDominioAData(actividad.getActividadConsumo(),
                actividad.getNumeroActividad()));
        return actividadData;
    }

    public static List<Actividad> convertirADataList(List<ActividadData> actividadData){
        return actividadData.stream().map(Convertidor::convertidorActividadDataADominio)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    public static Date convertidorDeFecha(String fecha)  {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        if (Objects.nonNull(fecha)) {
            return formatter.parse(fecha);
        }
        return null;
    }
    public static String convertidorDeFechaDto(Date fecha){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        if (Objects.nonNull(fecha)) {
            return formatter.format(fecha);
        }
        return null;
    }

}
