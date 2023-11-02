package com.huella.hidrica.repository.Actividad;

import com.huella.hidrica.model.Actividad.Actividad;

import java.util.List;
import java.util.stream.Collectors;

public class Convertidor {

    public static Actividad convertidorActividadDataADominio(ActividadData data){
             return Actividad
                     .builder()
                     .fechaInicio(data.getFechaInicio())
                     .numeroActividad(data.getNumeroActividad())
                     .tipoActividad(data.getTipoActividad())
                     .totalPromedioAgua(data.getPromedioAguaUsuario())
                     .totalPromedioForraje(data.getPromedioForrajeUsuario())
                     .totalPromedioLeche(data.getPromedioLecheUsuario())
                     .totalPromedioForrajeCalculadaSistema(data.getPromedioForrajeSistema())
                     .totalPromedioLecheCalculadaSistema(data.getPromedioLecheSistema())
                     .totalPromedioAguaCalculadaSistema(data.getPromedioAguaSistema())
                     .fechaFinal(data.getFechaFin())
                     .lavoCantinas(data.getLavadoCantinas().equals("S"))
                     .realizoRiego(data.getRiegoMangera().equals("S"))
                     .usuarioLoggeado(data.getUsuario())
                     .build();
    }

    public static ActividadData convertidorDeDominioAData(Actividad actividad){
        ActividadData actividadData = new ActividadData();
        actividadData.setNumeroActividad(actividadData.getNumeroActividad());
        actividadData.setFechaFin(actividad.getFechaFinal());
        actividadData.setFechaInicio(actividad.getFechaInicio());
        actividadData.setLavadoCantinas(actividad.getLavoCantinas() ? "S" : "N");
        actividadData.setTipoActividad(actividad.getTipoActividad());
        actividadData.setPromedioAguaSistema(actividad.getTotalPromedioAguaCalculadaSistema());
        actividadData.setPromedioForrajeSistema(actividad.getTotalPromedioForrajeCalculadaSistema());
        actividadData.setPromedioLecheSistema(actividad.getTotalPromedioLecheCalculadaSistema());
        actividadData.setPromedioLecheUsuario(actividad.getTotalPromedioLeche());
        actividadData.setPromedioForrajeUsuario(actividad.getTotalPromedioForraje());
        actividadData.setPromedioAguaUsuario(actividad.getTotalPromedioAgua());
        actividadData.setUsuario(actividad.getUsuarioLoggeado());
        actividadData.setCodigoPotrero(actividad.getCodigoPotrero());
        actividadData.setRiegoMangera(actividad.getRealizoRiego() ? "S" : "N");
        return actividadData;
    }

    public static List<Actividad> convertirADataList(List<ActividadData> actividadData){
        return actividadData.stream().map(Convertidor::convertidorActividadDataADominio)
                .collect(Collectors.toList());
    }

}
