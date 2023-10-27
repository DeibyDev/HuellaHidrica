package com.huella.hidrica.model.Departamento.gateway;

import com.huella.hidrica.controller.RespuestaGenerica;
import com.huella.hidrica.model.Departamento.Departamento;

import java.util.List;

public interface DepartamentoRepository {


    RespuestaGenerica<Departamento> listarDepartamentos();

}

