package io.github.zd4y.encicladisponibilidad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.github.zd4y.encicladisponibilidad.models.Station;

public class StationsListAdapter extends RecyclerView.Adapter<StationsListAdapter.ViewHolder> {

    private ArrayList<Station> dataset;

    public StationsListAdapter() {
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_station, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Station station = dataset.get(position);
        holder.nameTextView.setText(station.getName());
        String capacity = String.format(Locale.ENGLISH, "%d/%d", station.getBikes(), station.getCapacity());
        holder.capacityTextView.setText(capacity);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void setStations(List<Station> stations) {
        dataset = new ArrayList<>(stations);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView capacityTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            capacityTextView = (TextView) itemView.findViewById(R.id.capacityTextView);
        }
    }
}
