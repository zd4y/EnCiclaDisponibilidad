package io.github.zd4y.encicladisponibilidad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import io.github.zd4y.encicladisponibilidad.api.EnCiclaService;
import io.github.zd4y.encicladisponibilidad.models.Station;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ENCICLA";

    private Retrofit retrofit;

    private RecyclerView recyclerView;
    private StationsListAdapter stationsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        stationsListAdapter = new StationsListAdapter();
        recyclerView.setAdapter(stationsListAdapter);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://webapp.metropol.gov.co/wsencicla/api/Disponibilidad/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        listStations();
    }

    private void listStations() {
        EnCiclaService service = retrofit.create(EnCiclaService.class);
        service.listStations().enqueue(new Callback<List<Station>>() {
            @Override
            public void onResponse(Call<List<Station>> call, Response<List<Station>> response) {
                if (!response.isSuccessful()) {
                    Log.e(TAG, " onResponse: " + response.body());
                    return;
                }

                List<Station> stations = response.body();
//                for (Station station : stations) {
//                    Log.i(TAG, " Station: " + station);
//                }
                stationsListAdapter.setStations(stations);
            }

            @Override
            public void onFailure(Call<List<Station>> call, Throwable t) {
                Log.e(TAG, " onFailure: " + t.getMessage());
            }
        });
    }
}