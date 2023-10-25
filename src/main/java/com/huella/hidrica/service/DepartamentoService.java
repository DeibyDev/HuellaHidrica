package com.huella.hidrica.service;

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
    public Departamento listaDepartamento() {
        return Convertidor.convertirADepartamentoominio(departamentoDataRepository.findById("5").get());
    }

    @Override
    public List<Departamento> listarDepartamentos() {
        return Convertidor.listaDepartamentos(departamentoDataRepository.findAll());
    }
}
