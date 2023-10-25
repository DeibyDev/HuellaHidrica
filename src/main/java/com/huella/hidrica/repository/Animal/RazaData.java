package com.huella.hidrica.repository.Animal;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "raza")
public class RazaData {

    @Id
    @Column(name = "cod_raza")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   @Column(name = "nom_raza")
    private String nombreRaza;

}
