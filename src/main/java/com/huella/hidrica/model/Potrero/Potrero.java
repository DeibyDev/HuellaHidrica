package com.huella.hidrica.model.Potrero;

import com.huella.hidrica.model.Animal.Animal;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@Builder(toBuilder = true)
public class Potrero {
    private String codigoPotrero;
    private String nombrePotrero;
    private Float areaPotrero;
    private Float capacidadMaximaForraje;
    private Float capacidadMaximaAgua;
    private Integer cupoMaximoAnimales;
    private Integer codigoPasto;
    private String codigoFinca;
    private Optional<List<Animal>> animales;
}
