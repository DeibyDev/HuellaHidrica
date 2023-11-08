package com.huella.hidrica.model.Pasto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class Pasto {
    private Integer codigoPasto;
    private String nombrePasto;
    private List<ConfiguracionConstantes> configuracionConstantes;


}
