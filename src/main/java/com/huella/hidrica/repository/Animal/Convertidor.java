package com.huella.hidrica.repository.Animal;

import com.huella.hidrica.model.Animal.Animal;
import com.huella.hidrica.model.Animal.Raza;

import java.util.List;
import java.util.stream.Collectors;

public class Convertidor {

    public static Animal convertirAAnimaldominio(AnimalData data){
        return Animal.builder()
                .raza(convertidorARazaDominio(data.getCodigoRaza()))
                .fechaNacimiento(data.getFechaNacimiento())
                .numeroCrotal(data.getCodigoAnimal())
                .numeroPartos(data.getNumeroPartos())
                .nombreAnimal(data.getNombreAnimal())
                .codigoPotrero(data.getCodigoPotrero())
                .build();
    }
    public static  AnimalData convertidorAnimalData(Animal data){
       AnimalData animalData = new AnimalData();
       animalData.setCodigoAnimal(data.getNumeroCrotal());
       animalData.setCodigoRaza(convertidorARazaData(data.getRaza()));
       animalData.setFechaNacimiento(data.getFechaNacimiento());
       animalData.setNumeroPartos(data.getNumeroPartos());
       animalData.setNombreAnimal(data.getNombreAnimal());
       animalData.setCodigoPotrero(data.getCodigoPotrero());
       return animalData;
    }


    public static List<Animal> listarAnimales(List<AnimalData> animalData){
        return animalData.stream().map(Convertidor::convertirAAnimaldominio).collect(Collectors.toList());
    }

    public static Raza convertidorARazaDominio(RazaData data){
        return Raza.builder()
                .codigoRaza(data.getId())
                .nombreRaza(data.getNombreRaza())
                .build();
    }

    public static  RazaData convertidorARazaData(Raza data){
       RazaData razaData = new RazaData();
       razaData.setNombreRaza(data.getNombreRaza());
       return razaData;
    }

}
