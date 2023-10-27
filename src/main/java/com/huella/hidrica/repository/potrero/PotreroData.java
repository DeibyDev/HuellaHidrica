package com.huella.hidrica.repository.potrero;

import com.huella.hidrica.repository.Animal.AnimalData;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Potrero")
public class PotreroData {
    @Id
    @Column(name = "cod_potrero")
    private String codigoPotrero;

    @Column(name = "nom_potrero")
    private String nombrePotrero;

    @Column(name = "area_potrero")
    private Float areaPotrero;

    @Column(name = "cod_pasto")
    private Integer codigoPasto;

    @Column(name = "cap_Max_agua_azul")
    private Float capacidadMaximaAgua;

    @Column(name = "cupo_max_animales")
    private Integer capacidadMaximaAnimales;

    @Column(name = "cap_Max_forraje")
    private Float capacidadMaximaForraje;

    @Column(name = "cod_finca")
    private String codigoFinca;

    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_potrero")
    private List<AnimalData> animales;
}
