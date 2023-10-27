package com.huella.hidrica.model.Persona.gateway;

import com.huella.hidrica.controller.RespuestaGenerica;
import com.huella.hidrica.model.Persona.Persona;

public interface PersonaRepository {
     RespuestaGenerica<String> crearPersona(Persona persona);
     RespuestaGenerica<Boolean> buscarPersona(String idPersona);
}
