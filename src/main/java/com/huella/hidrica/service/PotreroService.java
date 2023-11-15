package com.huella.hidrica.service;

import com.huella.hidrica.controller.RespuestaGenerica;
import com.huella.hidrica.model.Potrero.Potrero;
import com.huella.hidrica.model.Potrero.gateway.PotreroRepository;
import com.huella.hidrica.repository.finca.Convertidor;
import com.huella.hidrica.repository.potrero.PotreroData;
import com.huella.hidrica.repository.potrero.PotreroDataRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PotreroService implements PotreroRepository {

    private final PotreroDataRepository potreroDataRepository;

    @Transactional
    @Override
    public RespuestaGenerica<String> crearPotrero(Potrero potrero) {
        try {
            Optional<PotreroData> potreroEncontrado = potreroDataRepository.findByNombrePotreroAndCodigoFinca(potrero.getNombrePotrero()
                    , potrero.getCodigoFinca());
            if (potreroEncontrado.isPresent()) {
                return new RespuestaGenerica<>(200, "1");
            }
            potreroDataRepository.save(Convertidor.convertirPotreroData(potrero));
            return new RespuestaGenerica<>(200, "0");
        } catch (Exception exception) {
            return new RespuestaGenerica<>(400, "Error en crear el potrero");
        }
    }

    @Override
    public RespuestaGenerica<Potrero> actualizarPotrero(Potrero potrero) {
        try {
            Optional<PotreroData> potreroEncontrado = potreroDataRepository.findById(potrero.getCodigoPotrero());
            if (potreroEncontrado.isPresent()) {
                Potrero potreroNuevo = potreroEncontrado.map(Convertidor::convertirPotreroADominio)
                        .map(potreroConvertido -> potreroConvertido
                                .toBuilder()
                                .areaPotrero(potrero.getAreaPotrero())
                                .nombrePotrero(potrero.getNombrePotrero())
                                .codigoPotrero(potrero.getCodigoPotrero())
                                .capacidadMaximaForraje(potrero.getCapacidadMaximaForraje())
                                .capacidadMaximaAgua(potrero.getCapacidadMaximaAgua())
                                .cupoMaximoAnimales(potrero.getCupoMaximoAnimales())
                                .codigoPasto(potrero.getCodigoPasto())
                                .build())
                        .map(potreroActualizado -> potreroDataRepository.save(Convertidor.convertirPotreroData(potreroActualizado)))
                        .map(Convertidor::convertirPotreroADominio)
                        .orElse(null);
                return new RespuestaGenerica<>(200, "0", potreroNuevo);
            }
            return new RespuestaGenerica<>(200, "1");
        } catch (Exception exception) {
            return new RespuestaGenerica<>(400, "Error al actualizar potrero");
        }
    }

    @Override
    public RespuestaGenerica<Boolean> eliminarPotrero(String codigoPotrero) {
        Optional<PotreroData> potreroEncontrado = potreroDataRepository.findById(codigoPotrero);
        try {
            if (potreroEncontrado.isPresent() && potreroEncontrado.get().getAnimales().isEmpty()) {
                            potreroDataRepository.deleteById(codigoPotrero);
                            return new RespuestaGenerica<>(200, "0", true);
            }
            return new RespuestaGenerica<>(200, "1");
        } catch (Exception exception) {
            return new RespuestaGenerica<>(400, "Error al elminar el  potrero");
        }
    }

    @Override
    public RespuestaGenerica<Potrero> listarPotrerosFinca(String numeroFinca) {
        try {
            List<Potrero> listarPotrerosFinca = Convertidor.listaPotreros(potreroDataRepository.findByCodigoFinca(numeroFinca));
            return new RespuestaGenerica<>(200, "0", listarPotrerosFinca);

        } catch (Exception exception) {
            return new RespuestaGenerica<>(400, "1");
        }
    }
}
