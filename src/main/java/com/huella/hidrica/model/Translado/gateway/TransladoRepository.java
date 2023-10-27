package com.huella.hidrica.model.Translado.gateway;

import com.huella.hidrica.controller.RespuestaGenerica;
import com.huella.hidrica.model.Animal.Animal;
import com.huella.hidrica.model.Translado.Translado;

public interface TransladoRepository {
    RespuestaGenerica<String> transladarAnimal(Translado translado);
}
