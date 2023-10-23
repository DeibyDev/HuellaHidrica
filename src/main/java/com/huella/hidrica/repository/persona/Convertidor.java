package com.huella.hidrica.repository.persona;

import com.huella.hidrica.model.Persona.Persona;

import java.util.Date;
import java.util.UUID;

public class Convertidor {

    public static Persona convertirAPersonaDominio(PersonaData personaData){
        return Persona.builder()
                .id_persona(UUID.randomUUID().toString())
                .fecha(new Date())
                .apellidos(personaData.getApellidos())
                .nombres(personaData.getNombres())
                .auditoriaUsuario(personaData.getAuditoriaUsuario())
                .tipo_documento(personaData.getTipoDocumento())
                .numero_documento(personaData.getNumeroDocumento())
                .build();
    }

    public static PersonaData convertirAPersonaData(Persona persona){
        PersonaData data = new PersonaData();
        data.setIdPersona(UUID.randomUUID().toString());
        data.setApellidos(persona.getApellidos());
        data.setNombres(persona.getNombres());
        data.setFecha(new Date());
        data.setNumeroDocumento(persona.getNumero_documento());
        data.setAuditoriaUsuario(data.getIdPersona());
        data.setTipoDocumento(persona.getTipo_documento());
        return data;
    }
}
