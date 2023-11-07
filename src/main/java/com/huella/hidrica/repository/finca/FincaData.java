package com.huella.hidrica.repository.finca;
import com.huella.hidrica.repository.municipio.MunicipioData;
import com.huella.hidrica.repository.persona.PersonaData;
import com.huella.hidrica.repository.potrero.PotreroData;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@Table(name = "finca")
@Entity
public class FincaData {
    @Id
    @Column(name = "cod_finca")
    private String numeroFinca;

    @Column(name = "per_id_persona")
    private String idPersona;

    @Column(name= "nom_finca")
    private String nombreFinca;

    @Column(name= "telefono")
    private String telefono;

    @Column(name= "cod_dpto")
    private Integer codigoDepartamento;

    @Column(name= "cod_municipio")
    private Integer codigoMunicipio;

    @Column(name = "nom_vereda")
    private String nombreVereda;

    @Column(name= "tipo_ordeno")
    private String tipoOrdeno;

    @Column(name= "nro_ordenos_dia")
    private Integer numeroOrdenos;

    @Column(name= "area_total")
    private Float areaTotal;

    @Column(name = "uso_suplemento")
    private String usoSuplemento;

    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_finca")
    private List<PotreroData> potreros;

}

