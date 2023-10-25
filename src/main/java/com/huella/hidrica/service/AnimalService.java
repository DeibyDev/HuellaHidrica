package com.huella.hidrica.service;

import com.huella.hidrica.model.Animal.Animal;
import com.huella.hidrica.model.Animal.gateway.AnimalRepository;
import com.huella.hidrica.repository.Animal.AnimalDataRepository;

import com.huella.hidrica.repository.Animal.Convertidor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimalService  implements AnimalRepository {

    private final AnimalDataRepository animalDataRepository;
    @Override
    public String crearAnimal(Animal animal) {
        try {
            return animalDataRepository.save(Convertidor.convertidorAnimalData(animal)).getCodigoAnimal();
        }catch (Exception exception){
            throw new RuntimeException("Error al guardar el animal" );
        }
    }
}
