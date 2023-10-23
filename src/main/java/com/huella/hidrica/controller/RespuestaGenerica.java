package com.huella.hidrica.controller;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class RespuestaGenerica<T> {

    private Integer code;
    private String mensaje;
    private String numeroTransaccion;

    private Date fecha;
    private T objeto;

    public RespuestaGenerica(Integer code, String mensaje, T objeto) {
        this.numeroTransaccion = UUID.randomUUID().toString();
        this.code = code;
        this.mensaje = mensaje;
        this.fecha = new Date();
        this.objeto = objeto;
    }

    public RespuestaGenerica(Integer code, String mensaje) {
        this.numeroTransaccion = UUID.randomUUID().toString();
        this.code = code;
        this.mensaje = mensaje;
        this.fecha = new Date();
    }
}
