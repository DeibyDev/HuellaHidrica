package com.huella.hidrica.model.Animal;

import com.huella.hidrica.model.Configuraciones.Configuracion;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@Builder(toBuilder = true)
public class Animal {
    private String numeroCrotal;
    private String nombreAnimal;
    private String fechaNacimiento;
    private Integer numeroPartos;
    private String codigoPotrero;
    private Raza raza;
    private Integer edadAnimal;
    private Optional<Configuracion> configuracion;
}
