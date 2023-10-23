package com.huella.hidrica.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AnimalDTO {
    private String numero;
    private String fecha;
    private Integer numeroPartos;
    private Integer codigoRaza;
}
