package com.huella.hidrica.repository.persona;

import com.huella.hidrica.model.Finca;
import com.huella.hidrica.repository.finca.FincaData;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@Table(name = "Persona")
@Entity
public class PersonaData {
    @Id
    @Column(name = "per_id_persona")
    private String idPersona;

    @Column(name= "per_tipo_documento")
    private String tipoDocumento;

    @Column(name= "per_numero_documento")
    private Integer numeroDocumento;

    @Column(name= "per_nombres")
    private String nombres;

    @Column(name= "per_apellidos")
    private String apellidos;

    @Column(name = "per_aud_usuario")
    private String auditoriaUsuario;

    @Column(name= "per_aud_fecha")
    private Date fecha;


}

