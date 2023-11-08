package com.huella.hidrica.service;

import com.huella.hidrica.DTO.ActvidadesCalculadasDTO;
import com.huella.hidrica.controller.RespuestaGenerica;
import com.huella.hidrica.model.Actividad.Actividad;
import com.huella.hidrica.model.Actividad.gateway.ActividadRepository;
import com.huella.hidrica.repository.Actividad.ActividadDataRepository;
import com.huella.hidrica.repository.Actividad.Convertidor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActividadService implements ActividadRepository {


    private final ActividadDataRepository actividadDataRepository;
    @Override
    public RespuestaGenerica<String> guardarActividad(Actividad actividad) {
        try {
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd");
            String fechaInicio = outputFormat.format(actividad.getFechaInicio());
            Date fechaFormateadaInicio = outputFormat.parse(fechaInicio);

            String fechaFin = outputFormat.format(actividad.getFechaFinal());
            Date fechaFormateadaFin = outputFormat.parse(fechaFin);
            actividad = actividad.toBuilder().fechaInicio(fechaFormateadaInicio).fechaFinal(fechaFormateadaFin).build();

            actividadDataRepository.save(Convertidor.convertidorDeDominioAData(actividad));
            return new RespuestaGenerica<>(200,"0");
        }catch (Exception exception){
            return new RespuestaGenerica<>(400,"Error al Guardar la Actividad");
        }
    }

    @Override
    public RespuestaGenerica<ActvidadesCalculadasDTO> listarActividadesPotreroFecha(String codigoPotrero, String fechaInicio, String fechaFin) {
       try{
           List<Actividad> actividadesEncontradas;
           if(Objects.nonNull(fechaFin) && Objects.nonNull(fechaInicio) && !fechaInicio.isEmpty() && !fechaFin.isEmpty()){
              actividadesEncontradas  = Convertidor.convertirADataList(actividadDataRepository.buscarPorFechaYCodigoPotrero(fechaInicio,fechaFin,codigoPotrero));
               Optional<Float> promedioConsumoAgua = actividadesEncontradas.stream().map(actividad -> actividad.getActividadConsumo().getTotalPromedioAgua()).reduce(Float::sum);
               Optional<Float> promedioConsumoForraje = actividadesEncontradas.stream().map(actividad -> actividad.getActividadConsumo().getTotalPromedioForraje()).reduce(Float::sum);
               Optional<Float> promedioConsumoLeche = actividadesEncontradas.stream().map(actividad -> actividad.getActividadConsumo().getTotalPromedioLeche()).reduce(Float::sum);
               ActvidadesCalculadasDTO actvidadesCalculadasDTO = ActvidadesCalculadasDTO
                       .builder()
                       .cantidadAguaUtilizada(promedioConsumoAgua.orElse((float) 0))
                       .cantidadForrajeConsumido(promedioConsumoForraje.orElse((float) 0))
                       .cantidadLecheProducida(promedioConsumoLeche.orElse((float) 0))
                       .listadoActividades(actividadesEncontradas)
                       .build();
               return new RespuestaGenerica<>(200, "0",actvidadesCalculadasDTO);
           }
           actividadesEncontradas= Convertidor.convertirADataList(actividadDataRepository.findByCodigoPotrero(codigoPotrero));
           return new RespuestaGenerica<>(200,"0",
                   ActvidadesCalculadasDTO
                           .builder()
                           .listadoActividades(actividadesEncontradas)
                           .build());

       }catch (Exception exception){
           return new RespuestaGenerica<>(400,"Error al listar actividades por fecha");
       }

    }
}
