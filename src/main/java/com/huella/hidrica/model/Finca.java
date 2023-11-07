package com.huella.hidrica.model;
import com.huella.hidrica.model.Potrero.Potrero;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder(toBuilder = true)
public class Finca {
    private String id_persona;
    private String codigoFinca;
    private String nombreFinca;
    private String numeroTelefono;
    private Integer codigoDepartamento;
    private Integer codigoMunicipio;
    private String nombreVereda;
    private String tipoOrdeno;
    private Integer numeroOrdenoDiario;
    private Float areaTotal;
    private String usoSuplemento;
    private List<Potrero> potreros;
}
