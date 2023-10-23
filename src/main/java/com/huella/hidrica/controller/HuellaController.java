package com.huella.hidrica.controller;

import com.huella.hidrica.model.Finca;
import com.huella.hidrica.model.Persona.Persona;
import com.huella.hidrica.service.FincaService;
import com.huella.hidrica.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Huella")
@RequiredArgsConstructor
public class HuellaController {

    private final FincaService fincaService;
    private final PersonaService personaService;

        @PostMapping("/crearFinca")
    public String crearFinca(@RequestBody Finca finca) {
        try {
            fincaService.crearFinca(finca);
            return "Finca Creada";
        } catch (Exception exception) {
            throw new RuntimeException("Error al crear la finca" + exception.getMessage());
        }

    }

    @PostMapping("/crearPersona")
    public ResponseEntity<RespuestaGenerica> registrarPersona(@RequestBody Persona persona){
        try {
            String idUsuarioRegistrado = personaService.crearPersona(persona);
               return new ResponseEntity<>(new RespuestaGenerica(200, idUsuarioRegistrado), HttpStatus.ACCEPTED);
        } catch (Exception exception) {
            return new ResponseEntity<>(new RespuestaGenerica(400, exception.getMessage()), HttpStatus.ACCEPTED);
        }
    }




}
