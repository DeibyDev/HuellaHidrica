package com.huella.hidrica.repository.departamento;

import com.huella.hidrica.repository.municipio.MunicipioData;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Table(name = "Departamentos")
@Entity
public class DepartamentoData {

    @Id
    @Column(name = "id_departamento")
    private Integer codigoDepartamento;

    @Column(name = "departamento")
    private String nombreDepartamento;

    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "id_departamento")
    private List<MunicipioData> municipios;

}
