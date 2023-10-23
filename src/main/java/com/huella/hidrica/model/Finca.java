package com.huella.hidrica.model;
import lombok.Builder;
import lombok.Data;


@Data
@Builder(toBuilder = true)
public class Finca {
    private String id_persona;
    private Integer codigoFinca;
    private String nombreFinca;
    private Integer numeroTelefono;
    private Integer codigoDepartamento;
    private Integer codigoMunicipio;
    private String nombreVereda;
    private String tipoOrdeno;
    private Integer numeroOrdenoDiario;
    private Float areaTotal;
    private String usoSuplemento;
}
