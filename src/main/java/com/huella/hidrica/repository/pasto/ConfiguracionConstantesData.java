package com.huella.hidrica.repository.pasto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "constantes")
public class ConfiguracionConstantesData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_constante")
    private Integer codigoConfiguracion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "valor")
    private float valor;

    @Column(name = "cod_pasto")
    private Integer codigoPasto;
}

