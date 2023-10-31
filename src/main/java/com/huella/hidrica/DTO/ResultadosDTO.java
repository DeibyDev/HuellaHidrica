package com.huella.hidrica.DTO;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class ResultadosDTO {
    private Float totalAguaPromedio;
    private Float totalForrajePromedio;
    private Float totalLechePromedio;
    private List<AnimalCalculadoDTO> animalCalculadoDTOS;
}
