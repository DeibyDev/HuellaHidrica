package com.huella.hidrica.service;

import com.huella.hidrica.DTO.AnimalCalculadoDTO;
import com.huella.hidrica.DTO.ResultadosDTO;
import com.huella.hidrica.controller.RespuestaGenerica;
import com.huella.hidrica.model.Animal.Animal;
import com.huella.hidrica.model.Animal.gateway.AnimalRepository;
import com.huella.hidrica.repository.Animal.AnimalDataRepository;

import com.huella.hidrica.repository.Animal.Convertidor;
import com.huella.hidrica.repository.Configuracion.ConfiguracionDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.MONTHS;


@Service
@RequiredArgsConstructor
public class AnimalService  implements AnimalRepository {

    private final AnimalDataRepository animalDataRepository;
    private final ConfiguracionDataRepository configuracionDataRepository;

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

    @Override
    public ResultadosDTO listarAnimalesPotrero(String codigoPotrero)  {
        try {

            List<AnimalCalculadoDTO> animalesCalculados = calcular(codigoPotrero);

            Optional<Float> aguaPromedio = animalesCalculados.stream().map(AnimalCalculadoDTO::getAguaPromedio).reduce(Float::sum);
            Optional<Float> forrajePromedio = animalesCalculados.stream().map(AnimalCalculadoDTO::getForrajePromedio).reduce(Float::sum);

            return  ResultadosDTO
                    .builder()
                    .animalCalculadoDTOS(animalesCalculados)
                    .totalAguaPromedio(aguaPromedio.orElse((float) 0))
                    .totalForrajePromedio(forrajePromedio.orElse((float) 0))
                    .totalLechePromedio((float) 0)
                    .build();
        }catch (Exception exception){
            return  null;
        }
    }

    public List<AnimalCalculadoDTO> calcular(String codigoPotrero){
        try{
        return  Convertidor.listarAnimales(animalDataRepository.findByCodigoPotrero(codigoPotrero))
                .stream()
                .map(animal -> {
                    try {
                        return animal.toBuilder().edadAnimal(calcularEdadAnimal(animal)).build();
                    } catch (ParseException exception) {
                        return null;
                    }
                }).filter(Objects::nonNull)
                .map(edadCalculada -> {
                    if (edadCalculada.getNumeroPartos() > 1){
                       return edadCalculada.toBuilder().configuracion(
                                        Optional.ofNullable(com.huella.hidrica.repository.Configuracion.Convertidor
                                                .convertirAConfiguracionDominio(configuracionDataRepository.findUserByParto(edadCalculada.getNumeroPartos()))))
                                .build();
                    }
                    return  edadCalculada.toBuilder().configuracion(
                                    Optional.ofNullable(com.huella.hidrica.repository.Configuracion.Convertidor
                                            .convertirAConfiguracionDominio(configuracionDataRepository.findUserByEdad(edadCalculada.getEdadAnimal()))))
                            .build();
                }).map(animal -> AnimalCalculadoDTO
                        .builder()
                        .codigoAnimal(animal.getNumeroCrotal())
                        .nombreAnimal(animal.getNombreAnimal())
                        .etapa(animal.getConfiguracion().isPresent() ? animal.getConfiguracion().get().getEtapa() : "Sin clasificacion")
                        .aguaPromedio(animal.getConfiguracion().isPresent() ? animal.getConfiguracion().get().getPorcentajeAgua() : 0)
                        .forrajePromedio(animal.getConfiguracion().isPresent() ? animal.getConfiguracion().get().getPorcentajeForraje() : 0)
                        .pesoPromedio(animal.getConfiguracion().isPresent() ? animal.getConfiguracion().get().getPeso() : "0" )
                        .build()
                )
                .collect(Collectors.toList());
    }catch (Exception exception){
        return  null;
    }

    }



    public Integer calcularEdadAnimal(Animal animal) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaActual = new Date();
        Date fechaNacimiento = formato.parse(animal.getFechaNacimiento());
        LocalDate localFechaActual = fechaActual.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localFechaNacimiento = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long mesesDiferencia = MONTHS.between(localFechaNacimiento, localFechaActual);
       return Math.toIntExact(mesesDiferencia);
    }
}
