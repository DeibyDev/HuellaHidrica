package com.huella.hidrica.model.Actividad.gateway;

import com.huella.hidrica.DTO.ActvidadesCalculadasDTO;
import com.huella.hidrica.controller.RespuestaGenerica;
import com.huella.hidrica.model.Actividad.Actividad;

public interface ActividadRepository {

    RespuestaGenerica<String> guardarActividad (Actividad actividad);

    RespuestaGenerica<ActvidadesCalculadasDTO> listarActividadesPotreroFecha(String codigoPotrero , String fechaInicio , String fechaFin);

}
