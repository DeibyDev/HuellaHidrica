package com.huella.hidrica.service;

import com.huella.hidrica.controller.RespuestaGenerica;
import com.huella.hidrica.model.Finca;

public interface IFinca {
    RespuestaGenerica<String> crearFinca(Finca finca);
    RespuestaGenerica buscarFinca(String numeroFinca);

}
