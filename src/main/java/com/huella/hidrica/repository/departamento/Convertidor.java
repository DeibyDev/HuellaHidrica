package com.huella.hidrica.repository.departamento;

import com.huella.hidrica.model.Departamento.Departamento;
import com.huella.hidrica.model.Municipio.Municipio;
import com.huella.hidrica.model.Persona.Persona;
import com.huella.hidrica.repository.municipio.MunicipioData;
import com.huella.hidrica.repository.persona.PersonaData;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class Convertidor {

    public static Departamento convertirADepartamentoominio(DepartamentoData departamentoData){
        return Departamento.builder()
                .codigoDepartamento(departamentoData.getCodigoDepartamento())
                .nombreDepartamento(departamentoData.getNombreDepartamento())
                .listaMunicipios(listaMunicipios(departamentoData.getMunicipios()))
                .build();
    }


    public static List<Departamento> listaDepartamentos(List<DepartamentoData> data){
        return data.stream()
                .map(Convertidor::convertirADepartamentoominio)
                .collect(Collectors.toList());

    }
    public static List<Municipio> listaMunicipios(List<MunicipioData> data){
        return data.stream()
                .map(Convertidor::convertidorAMunicipioDominio)
                .collect(Collectors.toList());

    }
    public static  Municipio convertidorAMunicipioDominio(MunicipioData data){
        return Municipio
                .builder()
                .codigoMunicipio(data.getCodigoMunicipio())
                .nombreMunicipio(data.getMunicipio())
                .build();
    }


}
