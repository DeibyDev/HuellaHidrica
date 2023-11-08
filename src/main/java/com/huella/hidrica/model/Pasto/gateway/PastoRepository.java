package com.huella.hidrica.model.Pasto.gateway;

import com.huella.hidrica.controller.RespuestaGenerica;
import com.huella.hidrica.model.Configuraciones.Configuracion;
import com.huella.hidrica.model.Pasto.ConfiguracionConstantes;
import com.huella.hidrica.model.Pasto.Pasto;

import java.util.List;

public interface PastoRepository {
    RespuestaGenerica<String> crearPasto(Pasto pasto);
    RespuestaGenerica<List<ConfiguracionConstantes>>listarConstantesPorPasto(Integer idPasto);
}
