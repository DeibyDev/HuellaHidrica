package com.huella.hidrica.service;

import com.huella.hidrica.controller.RespuestaGenerica;
import com.huella.hidrica.model.Animal.Animal;
import com.huella.hidrica.model.Translado.Translado;
import com.huella.hidrica.model.Translado.gateway.TransladoRepository;
import com.huella.hidrica.repository.Animal.AnimalDataRepository;
import com.huella.hidrica.repository.Animal.Convertidor;
import com.huella.hidrica.repository.Translado.TransladoDataRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransladoService implements TransladoRepository {

    private final TransladoDataRepository transladoDataRepository;
    private final AnimalDataRepository animalDataRepository;

    @Transactional
    @Override
    public RespuestaGenerica<String> transladarAnimal(Translado translado) {
        return animalDataRepository.findById(translado.getNumeroCrotal())
                .map(Convertidor::convertirAAnimaldominio)
                .map(animal -> Animal.builder()
                        .codigoPotrero(translado.getCodigoPotreroNuevo())
                        .raza(animal.getRaza())
                        .fechaNacimiento(animal.getFechaNacimiento())
                        .numeroCrotal(animal.getNumeroCrotal())
                        .numeroPartos(animal.getNumeroPartos())
                        .nombreAnimal(animal.getNombreAnimal())
                        .build())
                .map(animalActualizado -> {
                    animalDataRepository.save(com.huella.hidrica.repository.Animal.Convertidor.convertidorAnimalData(animalActualizado));
                    transladoDataRepository.save(com.huella.hidrica.repository.Translado.Convertidor.convertidorAnimalData(translado));
                    return new RespuestaGenerica<>(200, "0", "Animal trasladado");
                }).orElse(new RespuestaGenerica<>(200, "1", "No se logro trasladar el Animal"));
    }


}
