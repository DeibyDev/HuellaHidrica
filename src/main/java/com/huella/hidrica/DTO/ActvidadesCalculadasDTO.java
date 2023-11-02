package com.huella.hidrica.DTO;

import com.huella.hidrica.model.Actividad.Actividad;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class ActvidadesCalculadasDTO {
    private Float cantidadAguaUtilizada;
    private Float cantidadForrajeConsumido;
    private Float cantidadLecheProducida;
    private List<Actividad> listadoActividades;
}
