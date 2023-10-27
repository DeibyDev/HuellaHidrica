package com.huella.hidrica.repository.finca;

import com.huella.hidrica.model.Animal.Animal;
import com.huella.hidrica.model.Finca;
import com.huella.hidrica.model.Potrero.Potrero;
import com.huella.hidrica.repository.Animal.AnimalData;
import com.huella.hidrica.repository.potrero.PotreroData;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class Convertidor {

    public static Finca convertirAFincaDominio(FincaData fincaData){
        return Finca.builder()
                .id_persona(fincaData.getIdPersona())
                .codigoDepartamento(fincaData.getCodigoDepartamento())
                .codigoFinca(fincaData.getNumeroFinca())
                .areaTotal(fincaData.getAreaTotal())
                .nombreFinca(fincaData.getNombreFinca())
                .codigoMunicipio(fincaData.getCodigoMunicipio())
                .nombreVereda(fincaData.getNombreVereda())
                .numeroOrdenoDiario(fincaData.getNumeroOrdenos())
                .usoSuplemento(fincaData.getUsoSuplemento())
                .tipoOrdeno(fincaData.getTipoOrdeno())
                .numeroTelefono(fincaData.getTelefono())
                .potreros(listaPotreros(fincaData.getPotreros()))
                .build();
    }

    public static List<Finca> listarFincas(List<FincaData> data){
        return data.stream().map(Convertidor::convertirAFincaDominio)
                .collect(Collectors.toList());
    }

    public static FincaData convertirAFincaData(Finca finca){
        FincaData data = new FincaData();
        data.setIdPersona(finca.getId_persona());
        data.setAreaTotal(finca.getAreaTotal());
        data.setNombreFinca(finca.getNombreFinca());
        data.setNumeroFinca(finca.getCodigoFinca());
        data.setTelefono(finca.getNumeroTelefono());
        data.setCodigoMunicipio(finca.getCodigoMunicipio());
        data.setNombreVereda(finca.getNombreVereda());
        data.setNumeroOrdenos(finca.getNumeroOrdenoDiario());
        data.setTipoOrdeno(finca.getTipoOrdeno());
        data.setCodigoDepartamento(finca.getCodigoDepartamento());
        data.setPotreros(listaPotrerosData(finca.getPotreros()));
        data.setUsoSuplemento(finca.getUsoSuplemento());
        return data;
    }

    public static List<Potrero> listaPotreros(List<PotreroData> data){
        return data.stream().map(Convertidor::convertirPotreroADominio)
                .collect(Collectors.toList());
    }

    public static List<PotreroData> listaPotrerosData(List<Potrero> data){
        return data.stream().map(Convertidor::convertirPotreroData)
                .collect(Collectors.toList());
    }
    public static Potrero convertirPotreroADominio(PotreroData data){
        return Potrero.builder()
                .areaPotrero(data.getAreaPotrero())
                .capacidadMaximaAgua(data.getCapacidadMaximaAgua())
                .codigoPotrero(data.getCodigoPotrero())
                .nombrePotrero(data.getNombrePotrero())
                .codigoFinca(data.getCodigoFinca())
                .cupoMaximoAnimales(data.getCapacidadMaximaAnimales())
                .codigoPasto(data.getCodigoPasto())
                .capacidadMaximaForraje(data.getCapacidadMaximaForraje())
                .animales(Objects.nonNull(data.getAnimales()) ?
                        Optional.of(listaAnimal(data.getAnimales()))
                        : Optional.empty())
                .build();

    }

    public static  List<Animal> listaAnimal(List<AnimalData> animalData){
         return animalData.stream().map(com.huella.hidrica.repository.Animal
                 .Convertidor::convertirAAnimaldominio)
                 .collect(Collectors.toList());

    }

    public static  List<AnimalData> listaAnimalData(List<Animal> animals){
        return animals.stream().map(com.huella.hidrica.repository.Animal
                        .Convertidor::convertidorAnimalData)
                .collect(Collectors.toList());

    }


    public static PotreroData convertirPotreroData(Potrero data){
        PotreroData potreroData = new PotreroData();
        potreroData.setAreaPotrero(data.getAreaPotrero());
        potreroData.setCodigoPotrero(UUID.randomUUID().toString());
        potreroData.setNombrePotrero(data.getNombrePotrero());
        potreroData.setCodigoFinca(data.getCodigoFinca());
        potreroData.setCodigoPasto(data.getCodigoPasto());
        potreroData.setCapacidadMaximaAgua(data.getCapacidadMaximaAgua());
        potreroData.setCapacidadMaximaAnimales(data.getCupoMaximoAnimales());
        potreroData.setCapacidadMaximaForraje(data.getCapacidadMaximaForraje());
        potreroData.setAnimales(data.getAnimales().map(Convertidor::listaAnimalData)
                .orElse(null));
         return potreroData;
    }


}
