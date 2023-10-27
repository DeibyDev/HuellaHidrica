package com.huella.hidrica.repository.Translado;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "translado")
public class TransladoData {
    @Id
    @Column(name = "codigo_translado")
    private String codigoTranslado;

    @Column(name = "fech_ingreso")
    private String fechaIngreso;

    @Column(name = "peso_promedio")
    private Float pesoPromedio;

    @Column(name = "codigoPotreroNuevo")
    private String codigoPotrero;

    @Column(name = "codigoPotreroAntiguo")
    private String codigoPotreroAntiguo;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "Nro_crotal")
    private String numeroCotral;








}
