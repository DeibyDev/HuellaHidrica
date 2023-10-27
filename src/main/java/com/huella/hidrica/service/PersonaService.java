package com.huella.hidrica.service;

import com.huella.hidrica.controller.RespuestaGenerica;
import com.huella.hidrica.model.Persona.Persona;
import com.huella.hidrica.model.Persona.gateway.PersonaRepository;
import com.huella.hidrica.repository.persona.Convertidor;
import com.huella.hidrica.repository.persona.PersonaData;
import com.huella.hidrica.repository.persona.PersonaDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaService  implements PersonaRepository {

    private final PersonaDataRepository personaDataRepository;
    @Override
    public RespuestaGenerica<String> crearPersona(Persona persona) {
        Optional<PersonaData> personaEncontrada =  personaDataRepository.findByTipoDocumentoAndNumeroDocumento(persona.getTipo_documento(),persona.getNumero_documento());
        try {
        if (personaEncontrada.isPresent()){
            return new RespuestaGenerica<>(200,"1");
        }
        String idPersonaCreada = personaDataRepository.save(Convertidor.convertirAPersonaData(persona)).getIdPersona();
        return new RespuestaGenerica<>(200,idPersonaCreada);
        }catch (Exception exception){
            return new RespuestaGenerica<>(400,"Error al Crear la persona " , exception.getMessage());
        }
    }

    @Override
    public RespuestaGenerica<Boolean> buscarPersona(String idPersona) {
        try {
            Optional<PersonaData> personaEncontrada =  personaDataRepository.findById(idPersona);
            return new RespuestaGenerica<>(200,"1",personaEncontrada.isPresent());
        }catch (Exception exception){
            return new RespuestaGenerica<>(400 , "Error al buscar la persona " + exception.getMessage());

        }
    }

}
