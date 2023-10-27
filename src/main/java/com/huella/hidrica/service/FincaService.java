package com.huella.hidrica.service;

import com.huella.hidrica.controller.RespuestaGenerica;
import com.huella.hidrica.model.Finca;

import com.huella.hidrica.model.Persona.gateway.PersonaRepository;
import com.huella.hidrica.repository.finca.Convertidor;
import com.huella.hidrica.repository.finca.FincaData;
import com.huella.hidrica.repository.finca.FincaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class FincaService implements IFinca {

    private final FincaRepository fincaRepository;
    private final PersonaRepository personaRepository;
    @Transactional
    @Override
    public RespuestaGenerica<String> crearFinca(Finca finca) {
        try {
            Optional<FincaData> fincaEncontrada =  fincaRepository.findById(finca.getCodigoFinca());
            if (fincaEncontrada.isPresent()){
                return new RespuestaGenerica<>(200,"1"); // 1 : Si la finca ya existe
            }
             fincaRepository.save(Convertidor.convertirAFincaData(finca));
            return new RespuestaGenerica<>(200,"0"); // 0 : si la finca no existe y se guardo.
        }catch (Exception exception){
            return new RespuestaGenerica<>(400,"Error al Guardar la finca",exception.getMessage());
        }
    }

    @Override
    public RespuestaGenerica<Finca> buscarFinca(String numeroPropietario) {
        try {
            if(Boolean.TRUE.equals(personaRepository.buscarPersona(numeroPropietario).getObjeto())){
                List<Finca> fincasEncontradas = Convertidor.listarFincas(fincaRepository.findByIdPersona(numeroPropietario));
                return new RespuestaGenerica<>(200,"1",fincasEncontradas);
            }
            return new RespuestaGenerica<>(200,"0",new ArrayList<>());
        }catch (Exception exception){
            return new RespuestaGenerica<>(400,"Error al Guardar la finca");
    }
    }
}
