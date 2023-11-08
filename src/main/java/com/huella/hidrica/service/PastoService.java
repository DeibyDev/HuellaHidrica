package com.huella.hidrica.service;

import com.huella.hidrica.controller.RespuestaGenerica;
import com.huella.hidrica.model.Configuraciones.Configuracion;
import com.huella.hidrica.model.Pasto.ConfiguracionConstantes;
import com.huella.hidrica.model.Pasto.Pasto;
import com.huella.hidrica.model.Pasto.gateway.PastoRepository;
import com.huella.hidrica.repository.pasto.Convertidor;
import com.huella.hidrica.repository.pasto.PastoData;
import com.huella.hidrica.repository.pasto.PastoDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PastoService implements PastoRepository {

    private final PastoDataRepository pastoDataRepository;

    @Override
    public RespuestaGenerica<String> crearPasto(Pasto pasto) {
        try {
            Optional<PastoData> existe = pastoDataRepository.findByNombrePasto(pasto.getNombrePasto());
            if (existe.isPresent()) {
                return new RespuestaGenerica<>(200, "1");
            }
            pastoDataRepository.save(Convertidor.convertidorAData(pasto));
            return new RespuestaGenerica<>(200, "0");
        } catch (Exception exception) {
            return new RespuestaGenerica<>(400, "Error al Guardar el pasto", exception.getMessage());
        }
    }

    @Override
    public RespuestaGenerica<Pasto> listarConstantesPorPasto(Integer idPasto) {
        try {
        Optional<PastoData> configuracion = pastoDataRepository.findById(idPasto);
        if (configuracion.isPresent()){
            return new RespuestaGenerica<>(200, "0", Convertidor.
                    convertidorADominio(configuracion.orElse(null)));
        }
        return new RespuestaGenerica<>(200, "1" , new ArrayList<>());
        } catch (Exception exception) {
            return new RespuestaGenerica<>(400, "Error al Consultar el pasto");
        }
    }
}
