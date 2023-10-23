package com.huella.hidrica.repository.finca;

import com.huella.hidrica.model.Finca;

public class Convertidor {

    public static Finca convertirAFincaDominio(FincaData fincaData){
        return Finca.builder()
                .id_persona(fincaData.getIdPersona())
                .codigoDepartamento(fincaData.getCodigoDepartamento())
                .areaTotal(fincaData.getAreaTotal())
                .nombreFinca(fincaData.getNombreFinca())
                .codigoMunicipio(fincaData.getCodigoMunicipio())
                .nombreVereda(fincaData.getNombreVereda())
                .numeroOrdenoDiario(fincaData.getNumeroOrdenos())
                .usoSuplemento(fincaData.getUsoSuplemento())
                .tipoOrdeno(fincaData.getTipoOrdeno())
                .numeroTelefono(fincaData.getTelefono())
                .build();
    }

    public static FincaData convertirAFincaData(Finca finca){
        FincaData data = new FincaData();
        data.setIdPersona(finca.getId_persona());
        data.setAreaTotal(finca.getAreaTotal());
        data.setNombreFinca(finca.getNombreFinca());
        data.setNumeroFinca(finca.getCodigoFinca());
        data.setTelefono(finca.getNumeroTelefono());
        data.setCodigoMunicipio(finca.getCodigoMunicipio());
        data.setNombreVereda(finca.getNombreVereda());
        data.setNumeroOrdenos(finca.getNumeroOrdenoDiario());
        data.setTipoOrdeno(finca.getTipoOrdeno());
        return data;
    }


}
