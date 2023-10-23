package com.huella.hidrica.service;

import com.huella.hidrica.model.Finca;
import com.huella.hidrica.repository.finca.FincaData;

public interface IFinca {
    FincaData crearFinca(Finca finca);
    Finca buscarFinca(String numeroFinca);

}
