package com.huella.hidrica.repository.Configuracion;

import com.huella.hidrica.model.Configuraciones.Configuracion;

public class Convertidor {

    public static Configuracion convertirAConfiguracionDominio(ConfiguracionData configuracionData){
        return Configuracion.builder()
                .codigoConfiguracion(configuracionData.getCodigoConfiguracion())
                .etapa(configuracionData.getEtapa())
                .mesFin(configuracionData.getMesFin())
                .mesInicio(configuracionData.getMesInicio())
                .numeroPartosFin(configuracionData.getNumeroPartosFin())
                .numeroPartosInicio(configuracionData.getNumeroPartosInicio())
                .peso(configuracionData.getPeso())
                .porcentaje(Float.valueOf(configuracionData.getPorcentaje()))
                .porcentajeAgua(Float.valueOf(configuracionData.getPorcentajeAgua()))
                .porcentajeForraje(Float.valueOf(configuracionData.getPorcentajeForraje()))
                .build();
    }


}
