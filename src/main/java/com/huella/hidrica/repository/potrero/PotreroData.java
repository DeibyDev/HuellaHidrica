package com.huella.hidrica.repository.potrero;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Potrero")
public class PotreroData {
    @Id
    @Column(name = "cod_potrero")
    private Integer codigoPotrero;

    @Column(name = "nom_potrero")
    private String nombrePotrero;

    @Column(name = "area_potrero")
    private Float areaPotrero;

    @Column(name = "cod_pasto")
    private Integer codigoPasto;

    @Column(name = "cap_Max_agua_azul")
    private String capacidadMaximaAgua;

    @Column(name = "cupo_max_animales")
    private String capacidadMaximaAnimales;

    @Column(name = "cap_Max_forraje")
    private String capacidadMaximaForraje;

    @Column(name = "cod_finca")
    private String codigoFinca;
}
