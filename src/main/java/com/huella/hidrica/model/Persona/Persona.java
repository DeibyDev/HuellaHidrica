package com.huella.hidrica.model.Persona;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder(toBuilder = true)
public class Persona {

    private String id_persona;
    private String tipo_documento;
    private String numero_documento;
    private String nombres;
    private String apellidos;
    private String auditoriaUsuario;
    private Date fecha;


}
