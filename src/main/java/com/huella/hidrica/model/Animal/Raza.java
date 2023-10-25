package com.huella.hidrica.model.Animal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Raza {
    private Long codigoRaza;
    private String nombreRaza;
}

