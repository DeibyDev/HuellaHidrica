package com.huella.hidrica.repository.pasto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Pasto")
public class PastoData {
    @Id
    @Column(name = "cod_pasto")
    private Integer codigoPasto;

    @Column(name = "nombre_pasto")
    private String nombrePasto;


}
