package com.huella.hidrica.model.Animal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Animal {
    private String numeroCrotal;
    private String fechaNacimiento;
    private Integer numeroPartos;
    private Raza raza;
}
