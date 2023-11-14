package com.huella.hidrica.model.Potrero.gateway;

import com.huella.hidrica.controller.RespuestaGenerica;
import com.huella.hidrica.model.Potrero.Potrero;

import java.util.List;

public interface PotreroRepository {

    RespuestaGenerica<String> crearPotrero(Potrero potrero);

    RespuestaGenerica<Potrero> actualizarPotrero(Potrero potrero);

    RespuestaGenerica<Boolean> eliminarPotrero(String codigoPotrero);

    RespuestaGenerica<Potrero> listarPotrerosFinca(String numeroFinca);
}
