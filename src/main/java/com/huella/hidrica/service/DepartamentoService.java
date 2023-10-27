package com.huella.hidrica.service;

import com.huella.hidrica.controller.RespuestaGenerica;
import com.huella.hidrica.model.Departamento.Departamento;
import com.huella.hidrica.model.Departamento.gateway.DepartamentoRepository;
import com.huella.hidrica.repository.departamento.Convertidor;
import com.huella.hidrica.repository.departamento.DepartamentoDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartamentoService implements DepartamentoRepository {

    private final DepartamentoDataRepository departamentoDataRepository;

    @Override
    public RespuestaGenerica<Departamento> listarDepartamentos() {
        try {
            List<Departamento> departamentos = Convertidor.listaDepartamentos(departamentoDataRepository.findAll());
            return new RespuestaGenerica<>(200 ,"0",departamentos);
        }catch (Exception exception){
          return new RespuestaGenerica<>(400, "1" + exception.getMessage());
        }
    }
}
