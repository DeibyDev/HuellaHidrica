package com.huella.hidrica.repository.Configuracion;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "configuraciones")
@Entity
public class ConfiguracionData {

    @Id
    @Column(name = "codigo_configuracion")
    private Integer codigoConfiguracion;

    @Column(name = "inicio")
    private Integer mesInicio ;

    @Column(name = "fin")
    private Integer mesFin ;

    @Column(name = "numero_partos_inicio")
    private Integer numeroPartosInicio;

    @Column(name = "numero_partos_final")
    private Integer numeroPartosFin;

    @Column(name = "peso")
    private String peso;

    @Column(name = "porcentaje")
    private Integer porcentaje;

    @Column(name = "porcentaje_forraje")
    private Integer porcentajeForraje;

    @Column(name = "porcentaje_agua")
    private Integer porcentajeAgua;

    @Column(name = "etapa")
    private String etapa;





}
