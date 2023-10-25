package com.huella.hidrica.controller;

import com.huella.hidrica.model.Animal.Animal;
import com.huella.hidrica.model.Departamento.Departamento;
import com.huella.hidrica.model.Finca;
import com.huella.hidrica.model.Municipio.Municipio;
import com.huella.hidrica.model.Persona.Persona;
import com.huella.hidrica.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/Huella")
@RequiredArgsConstructor
public class HuellaController {

    private final FincaService fincaService;
    private final PersonaService personaService;
    private final MunicipioService municipioService;
    private final DepartamentoService departamentoService;
    private final AnimalService animalService;


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

    @GetMapping("/listarMunicipio/{codigoDepartamento}")
    public ResponseEntity<List<Municipio>> listarMunicipio(@PathVariable Integer codigoDepartamento ){
        try {
            List<Municipio> municipiosPorDepartamento = municipioService.listarMunicipios(codigoDepartamento);
            return new ResponseEntity<>(municipiosPorDepartamento, HttpStatus.ACCEPTED);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.ACCEPTED);
        }
    }


    @GetMapping("/listarDepartamento")
    public ResponseEntity<Departamento> listarDepartamento(){
        try {
            Departamento departamentos = departamentoService.listaDepartamento();
            return new ResponseEntity<>(departamentos, HttpStatus.ACCEPTED);
        } catch (Exception exception) {
            return new ResponseEntity<>(Departamento.builder().build(), HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/listarDepartamentos")
    public ResponseEntity<List<Departamento>> listarDepartamentos(){
        try {
            List<Departamento> departamentos = departamentoService.listarDepartamentos();
            return new ResponseEntity<>(departamentos, HttpStatus.ACCEPTED);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.ACCEPTED);
        }
    }

    @PostMapping("/crearAnimal")
    public ResponseEntity<RespuestaGenerica> crearAnimal(@RequestBody  Animal animal){
        try {
            String idAnimal = animalService.crearAnimal(animal);
            return new ResponseEntity<>(new RespuestaGenerica(200, idAnimal), HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(new RespuestaGenerica(400, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


}
