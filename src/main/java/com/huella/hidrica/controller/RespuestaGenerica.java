package com.huella.hidrica.controller;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data

public class RespuestaGenerica<T> {

    private Integer code;
    private String mensaje;
    private String numeroTransaccion;
    private List<T> listaResultado;

    private Date fecha;
    private T objeto;
    private Set<T> set;

    public RespuestaGenerica(Integer code, String mensaje, T objeto) {
        this.numeroTransaccion = UUID.randomUUID().toString();
        this.code = code;
        this.mensaje = mensaje;
        this.fecha = new Date();
        this.objeto = objeto;
    }



    public RespuestaGenerica(Integer code, String mensaje, List<T> listaResultado) {
        this.code = code;
        this.mensaje = mensaje;
        this.numeroTransaccion = UUID.randomUUID().toString();
        this.listaResultado = listaResultado;
        this.fecha = new Date();
    }

    public RespuestaGenerica(Integer code, String mensaje) {
        this.numeroTransaccion = UUID.randomUUID().toString();
        this.code = code;
        this.mensaje = mensaje;
        this.fecha = new Date();
    }
}
