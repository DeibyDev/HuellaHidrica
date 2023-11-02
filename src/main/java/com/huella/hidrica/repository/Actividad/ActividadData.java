package com.huella.hidrica.repository.Actividad;

import com.huella.hidrica.repository.Animal.RazaData;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "actividad")
public class ActividadData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Nro_actividad")
    private Integer numeroActividad;

    @Column(name = "cod_potrero")
    private String codigoPotrero;

    @Column(name = "tipo_actividad")
    private String tipoActividad;

    @Column(name = "total_promedio_agua_sys")
    private Float promedioAguaSistema;

    @Column(name = "total_promedio_forraje_sys")
    private Float promedioForrajeSistema;

    @Column(name = "total_promedio_leche_sys")
    private Float promedioLecheSistema;

    @Column(name = "total_promedio_agua_user")
    private Float promedioAguaUsuario;

    @Column(name = "total_promedio_forraje_user")
    private Float promedioForrajeUsuario;

    @Column(name = "total_promedio_leche_user")
    private Float promedioLecheUsuario;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Column(name = "lavado_cantinas")
    private String lavadoCantinas;

    @Column(name = "riego_mangera")
    private String riegoMangera;

    @Column(name = "usuario_registro")
    private String usuario;

}
