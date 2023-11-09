package com.huella.hidrica.repository.pasto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "pasto")
public class PastoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_pasto")
    private Integer codigoPasto;

    @Column(name = "nombre_pasto")
    private String nombrePasto;

    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_pasto")
    private List<ConfiguracionConstantesData> configuracionConstantesData;

}
