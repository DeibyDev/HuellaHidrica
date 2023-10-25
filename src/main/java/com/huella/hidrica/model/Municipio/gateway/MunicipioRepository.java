package com.huella.hidrica.model.Municipio.gateway;

import com.huella.hidrica.model.Municipio.Municipio;

import java.util.List;
import java.util.Set;

public interface MunicipioRepository {
    List<Municipio> listarMunicipios(Integer codigoDepartamento);
}
