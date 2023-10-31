package com.huella.hidrica.controller;

import com.huella.hidrica.DTO.ResultadosDTO;
import com.huella.hidrica.model.Animal.Animal;
import com.huella.hidrica.model.Departamento.Departamento;
import com.huella.hidrica.model.Finca;
import com.huella.hidrica.model.Persona.Persona;
import com.huella.hidrica.model.Potrero.Potrero;
import com.huella.hidrica.model.Translado.Translado;
import com.huella.hidrica.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Huella")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class HuellaController {

    private final FincaService fincaService;
    private final PersonaService personaService;
    private final DepartamentoService departamentoService;
    private final AnimalService animalService;
    private final TransladoService transladoService;
    private final PotreroService potreroService;


    @PostMapping("/crearPersona")
    public RespuestaGenerica<String> registrarPersona(@RequestBody Persona persona) {
        try {
            return personaService.crearPersona(persona);
        } catch (Exception exception) {
            return new RespuestaGenerica<>(400, "Error Al crear la Persona");
        }
    }

    @PostMapping("/crearFinca")
    public RespuestaGenerica<String> crearFinca(@RequestBody Finca finca) {
        try {
            return fincaService.crearFinca(finca);
        } catch (Exception exception) {
            return new RespuestaGenerica<>(400, "Error al crear la finca");
        }
    }

    @GetMapping("/listarFinca/{numeroPropietario}")
    public RespuestaGenerica<Finca> listarFincaPropietario(@PathVariable String numeroPropietario) {
        try {
            return fincaService.buscarFinca(numeroPropietario);
        } catch (Exception exception) {
            return new  RespuestaGenerica<>(400,"Error al consultar las fincas");
        }
    }



    @PostMapping("/crearPotrero")
    public RespuestaGenerica<String> crearFinca(@RequestBody Potrero potrero) {
        try {
            return potreroService.crearPotrero(potrero);
        } catch (Exception exception) {
            return new RespuestaGenerica<>(400,"Error al crear el potrero");
        }
    }


    @GetMapping("/listarPotrero/{codigoFinca}")
    public RespuestaGenerica<Potrero> listarPotrero(@PathVariable String codigoFinca) {
        try {
            return potreroService.listarPotrerosFinca(codigoFinca);
        } catch (Exception exception) {
            return new RespuestaGenerica<>(400,"Error al Cargar la lista de los potreros");
        }
    }


    @GetMapping("/listarDepartamentos")
    public RespuestaGenerica<Departamento> listarDepartamentos() {
        try {
            return departamentoService.listarDepartamentos();
        } catch (Exception exception) {
            return new RespuestaGenerica<>(400,"Error al Consultar los departamentos");
        }
    }

    @PostMapping("/crearAnimal")
    public RespuestaGenerica<String> crearAnimal(@RequestBody Animal animal) {
        try {
           return animalService.crearAnimal(animal);
        } catch (Exception exception) {
            return new RespuestaGenerica<>(400,"Error al crear el animal");
        }
    }

    @PostMapping("/transaladarAnimal")
    public RespuestaGenerica<String> transladarAnimal(@RequestBody Translado translado) {
        try {
           return transladoService.transladarAnimal(translado);
        } catch (Exception exception) {
           return new RespuestaGenerica<>(400,"Error al trasladar el animal a otro potrero");
        }
    }

    @GetMapping("/listarAnimales")
    public RespuestaGenerica<Animal> listarAnimales() {
        try {
            return animalService.listarAnimales();
        } catch (Exception exception) {
            return new RespuestaGenerica<>(400,"Error al listar los animales");
        }
    }

    @GetMapping("/calcularEdad/{codigoPotrero}")
    public ResultadosDTO listarEdades(@PathVariable String codigoPotrero) {
        try {
            return animalService.listarAnimalesPotrero(codigoPotrero);
        } catch (Exception exception) {
            return null;
        }
    }





}
