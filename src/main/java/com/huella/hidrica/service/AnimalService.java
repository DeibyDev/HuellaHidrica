package com.huella.hidrica.service;

import com.huella.hidrica.controller.RespuestaGenerica;
import com.huella.hidrica.model.Animal.Animal;
import com.huella.hidrica.model.Animal.gateway.AnimalRepository;
import com.huella.hidrica.repository.Animal.AnimalDataRepository;

import com.huella.hidrica.repository.Animal.Convertidor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService  implements AnimalRepository {

    private final AnimalDataRepository animalDataRepository;
    @Override
    public RespuestaGenerica<String> crearAnimal(Animal animal) {
        try {
            animalDataRepository.save(Convertidor.convertidorAnimalData(animal));
            return new RespuestaGenerica<>(200,"0");
        }catch (Exception exception){
            return new RespuestaGenerica<>(400,"Error al crear el animal");
        }
    }

    @Override
    public RespuestaGenerica<Animal> listarAnimales() {
        try {
            List<Animal> animalesRegistrados = Convertidor.listarAnimales(animalDataRepository.findAll());
            return new RespuestaGenerica<>(200,"0",animalesRegistrados);
        }catch (Exception exception){
            return new RespuestaGenerica<>(200,"Error al listar los animales " + exception.getMessage());
        }
    }
}
