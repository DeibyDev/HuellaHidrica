package com.huella.hidrica.model.Animal.gateway;

import com.huella.hidrica.controller.RespuestaGenerica;
import com.huella.hidrica.model.Animal.Animal;

import java.util.List;

public interface AnimalRepository {
    RespuestaGenerica<String> crearAnimal(Animal animal);

    RespuestaGenerica<Animal> listarAnimales();

    List<Animal> listarAnimalesPotrero(String codigoPotrero);
}
