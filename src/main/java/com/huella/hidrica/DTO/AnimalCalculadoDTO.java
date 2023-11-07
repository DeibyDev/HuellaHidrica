package com.huella.hidrica.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder(toBuilder = true)
public class AnimalCalculadoDTO {
    private String codigoAnimal;
    private String nombreAnimal;
    private String etapa;
    private String pesoPromedio;
    private Float aguaPromedio;
    private Float forrajePromedio;

}
