package com.huella.hidrica.service;

import com.huella.hidrica.model.Finca;

import com.huella.hidrica.repository.finca.Convertidor;
import com.huella.hidrica.repository.finca.FincaData;
import com.huella.hidrica.repository.finca.FincaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FincaService implements IFinca {

    private final FincaRepository fincaRepository;

    @Override
    public FincaData crearFinca(Finca finca) {
        try {
            return fincaRepository.save(Convertidor.convertirAFincaData(finca));
        }catch (Exception exception){
            throw new RuntimeException("Error al guardar la finca");
        }
    }

    @Override
    public Finca buscarFinca(String numeroFinca) {
        return null;
    }
}
