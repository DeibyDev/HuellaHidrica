package com.huella.hidrica.repository.Translado;

import com.huella.hidrica.model.Animal.Animal;
import com.huella.hidrica.model.Animal.Raza;
import com.huella.hidrica.model.Translado.Translado;

import java.util.Optional;
import java.util.UUID;

public class Convertidor {

    public static Translado convertirAAnimaldominio(TransladoData data){
        return Translado.builder()
                .pesoPromedio(data.getPesoPromedio())
                .observaciones(Optional.ofNullable(data.getObservaciones()))
                .codigoPotreroNuevo(data.getCodigoPotrero())
                .codigoPotreroAntiguo(data.getCodigoPotreroAntiguo())
                .numeroCrotal(data.getNumeroCotral())
                .codigoTranslado(data.getCodigoTranslado())
                .fechaIngreso(data.getFechaIngreso())
                .build();
    }
    public static TransladoData convertidorAnimalData(Translado data){
       TransladoData transladoData = new TransladoData();
       transladoData.setCodigoTranslado(UUID.randomUUID().toString());
       transladoData.setCodigoPotrero(data.getCodigoPotreroNuevo());
       transladoData.setCodigoPotreroAntiguo(data.getCodigoPotreroAntiguo());
       transladoData.setFechaIngreso(data.getFechaIngreso());
       transladoData.setObservaciones(data.getObservaciones().map(String::toUpperCase).orElse(null));
       transladoData.setNumeroCotral(data.getNumeroCrotal());
       transladoData.setPesoPromedio(data.getPesoPromedio());
       return transladoData;
    }

}
