package com.huella.hidrica.service;

import com.huella.hidrica.model.Municipio.Municipio;
import com.huella.hidrica.model.Municipio.gateway.MunicipioRepository;
import com.huella.hidrica.repository.municipio.MunicipioDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MunicipioService implements MunicipioRepository {

    private final MunicipioDataRepository municipioDataRepository;

    @Override
    public List<Municipio> listarMunicipios(Integer codigoDepartamento) {
        return new ArrayList<>();
    }
}
