package com.huella.hidrica.repository.Actividad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "actividad" )
public class ActividadData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Nro_actividad")
    private Integer numeroActividad;

    @Column(name = "cod_potrero")
    private String codigoPotrero;

    @Column(name = "tipo_actividad")
    private String tipoActividad;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Column(name = "usuario_registro")
    private String usuario;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private ActividadConsumoData actividaConsumoData;
}
