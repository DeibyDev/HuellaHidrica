package com.huella.hidrica.repository.Animal;

import com.huella.hidrica.model.Animal.Animal;
import com.huella.hidrica.model.Animal.Raza;

public class Convertidor {

    public static Animal convertirAAnimaldominio(AnimalData data){
        return Animal.builder()
                .raza(convertidorARazaDominio(data.getCodigoRaza()))
                .fechaNacimiento(data.getFechaNacimiento())
                .numeroCrotal(data.getCodigoAnimal())
                .numeroPartos(data.getNumeroPartos())
                .build();
    }
    public static  AnimalData convertidorAnimalData(Animal data){
       AnimalData animalData = new AnimalData();
       animalData.setCodigoAnimal(data.getNumeroCrotal());
       animalData.setCodigoRaza(convertidorARazaData(data.getRaza()));
       animalData.setFechaNacimiento(data.getFechaNacimiento());
       animalData.setNumeroPartos(data.getNumeroPartos());
       return animalData;
    }

    public static Raza convertidorARazaDominio(RazaData data){
        return Raza.builder()
                .codigoRaza(data.getId())
                .nombreRaza(data.getNombreRaza())
                .build();
    }

    public static  RazaData convertidorARazaData(Raza data){
       RazaData razaData = new RazaData();
       razaData.setId(data.getCodigoRaza());
       razaData.setNombreRaza(data.getNombreRaza());
       return razaData;
    }

}
