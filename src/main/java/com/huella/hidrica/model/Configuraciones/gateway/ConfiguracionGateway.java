package com.huella.hidrica.model.Configuraciones.gateway;

import com.huella.hidrica.model.Configuraciones.Configuracion;


public interface ConfiguracionGateway {
    Configuracion configuracionEdad(Integer edad);
    Configuracion configuracionParto(Integer parto);

}
