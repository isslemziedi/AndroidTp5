package com.example.tp6offresemploi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private List<Offre> offresList;

    // Constructor
    public CustomAdapter(List<Offre> offresList) {
        this.offresList = offresList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Offre o = offresList.get(position);

        // Assuming getId(), getPoste(), and getDescription() return Strings.
        holder.id.setText(o.getId());
        holder.poste.setText(o.getPoste());
        holder.desc.setText(o.getDescription());
    }

    @Override
    public int getItemCount() {
        return offresList != null ? offresList.size() : 0; // Null safety check
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView id;
        public TextView poste;
        public TextView desc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idOffre);
            poste = itemView.findViewById(R.id.nomOffre);
            desc = itemView.findViewById(R.id.descOffre);
        }
    }
}
