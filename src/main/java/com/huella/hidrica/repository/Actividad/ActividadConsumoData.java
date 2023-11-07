package com.huella.hidrica.repository.Actividad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
@Table(name = "actividad_consumo" )
public class ActividadConsumoData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_actividad_consumo")
    private Integer numeroActividadConsumo;

    @Column(name = "nro_actividad")
    private Integer codigoActividad;

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

    @Column(name = "total_consumo_directo")
    private Float totalConsumodirecto;

    @Column(name = "total_consumo_indirecto")
    private Float totalConsumoIndirecto;

    @Column(name = "total_consumo_servicio")
    private Float totalConsumoServicio;

    @Column(name = "total_area_utilizada")
    private Float totalAreaUtilizada;

    @Column(name = "total_consumo_agua_produccion")
    private Float totalConsumoAguaProduccion;

    @Column(name = "total_consumo_forraje_produccion")
    private Float totalConsumoForrajeProduccion;

    @Column(name = "total_huella_azul")
    private Float huellaAzul;

    @Column(name = "total_huella_verde")
    private Float huellaVerde;

    @Column(name = "total_huella_hidrica")
    private Float huellaHidrica;

}
