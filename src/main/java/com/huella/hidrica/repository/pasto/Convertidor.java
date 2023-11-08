package com.huella.hidrica.repository.pasto;

import com.huella.hidrica.model.Pasto.ConfiguracionConstantes;
import com.huella.hidrica.model.Pasto.Pasto;

import java.util.List;
import java.util.stream.Collectors;

public class Convertidor {

    public static Pasto convertidorADominio(PastoData data){
        return Pasto.builder()
                .codigoPasto(data.getCodigoPasto())
                .nombrePasto(data.getNombrePasto())
                .configuracionConstantes(configuracionConstantesData(data.getConfiguracionConstantesData()))
                .build();
    }
    public static ConfiguracionConstantes convertidorConfiguracionADominio (ConfiguracionConstantesData configuracionConstantesData){
        return ConfiguracionConstantes
                .builder()
                .codigoConfiguracion(configuracionConstantesData.getCodigoConfiguracion())
                .codigoPasto(configuracionConstantesData.getCodigoPasto())
                .descripcion(configuracionConstantesData.getDescripcion())
                .nombre(configuracionConstantesData.getNombre())
                .valor(configuracionConstantesData.getValor())
                .build();
    }

    public static List<Pasto> convertidoListaADominio(List<PastoData> data){
        return data.stream().map(Convertidor::convertidorADominio).collect(Collectors.toList());
    }

    public static PastoData convertidorAData(Pasto pasto){
        PastoData data = new PastoData();
        data.setCodigoPasto(pasto.getCodigoPasto());
        data.setNombrePasto(pasto.getNombrePasto());
        data.setConfiguracionConstantesData(pasto.getConfiguracionConstantes().stream()
                .map(configuracionConstantes ->
                        converitodorConfiguracionAData(configuracionConstantes,
                                pasto.getCodigoPasto()))
                .collect(Collectors.toList()));
        return data;
    }



    public static List<ConfiguracionConstantes> configuracionConstantesData (List<ConfiguracionConstantesData> configuracionConstantesData){
        return configuracionConstantesData.stream()
                .map(Convertidor::convertidorConfiguracionADominio)
                .collect(Collectors.toList());
    }
    public static ConfiguracionConstantesData converitodorConfiguracionAData(ConfiguracionConstantes configuracionConstantes,Integer codigoPasto){
        ConfiguracionConstantesData data  = new ConfiguracionConstantesData();
        data.setDescripcion(configuracionConstantes.getDescripcion());
        data.setNombre(configuracionConstantes.getNombre());
        data.setValor(configuracionConstantes.getValor());
        data.setCodigoPasto(codigoPasto);
        return data;
    }
}
