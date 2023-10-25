package com.huella.hidrica.model.Pasto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Pasto {
    private Integer codigoPasto;
    private String nombrePasto;
}
