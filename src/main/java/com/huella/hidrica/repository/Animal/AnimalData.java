package com.huella.hidrica.repository.Animal;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "animal")
public class AnimalData {
    @Id
    @Column(name = "Nro_crotal")
    private String codigoAnimal;

    @Column(name = "Nombre")
    private String nombreAnimal;

    @Column(name = "fech_nacimiento")
    private String fechaNacimiento;

    @Column(name = "Nro_partos")
    private Integer numeroPartos;

    @Column(name = "cod_potrero")
    private String codigoPotrero;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private RazaData codigoRaza;



}
