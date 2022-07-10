package io.github.zd4y.encicladisponibilidad.api;

import java.util.List;

import io.github.zd4y.encicladisponibilidad.models.Station;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EnCiclaService {
    @GET("GetDisponibilidadMapas")
    Call<List<Station>> listStations();
}
