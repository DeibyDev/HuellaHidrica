package com.huella.hidrica.service;

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
    public String crearPersona(Persona persona) {
        Optional<PersonaData> personaEncontrada =  personaDataRepository.findByTipoDocumentoAndNumeroDocumento(persona.getTipo_documento(),persona.getNumero_documento());
        if (personaEncontrada.isPresent()){
            return "1";
        }
      return  personaDataRepository.save(Convertidor.convertirAPersonaData(persona)).getIdPersona();
    }

}
