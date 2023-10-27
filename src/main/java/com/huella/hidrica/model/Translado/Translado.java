package com.huella.hidrica.model.Translado;


import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@Builder(toBuilder = true)
public class Translado {
    private String codigoTranslado;
    private String fechaIngreso;
    private Float  pesoPromedio;
    private String codigoPotreroNuevo;
    private String codigoPotreroAntiguo;
    private Optional<String> observaciones;
    private String numeroCrotal;
}
