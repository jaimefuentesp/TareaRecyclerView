package com.jaimefuentesp.tarearecyclerview.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaimefuentesp.tarearecyclerview.R;
import com.jaimefuentesp.tarearecyclerview.pojo.Mascota;

import java.util.ArrayList;

public class FotoAdapter extends RecyclerView.Adapter<FotoAdapter.FotoMascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public FotoAdapter (ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas=mascotas;
        this.activity=activity;
    }

    @NonNull
    @Override
    public FotoMascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_foto_mascota,parent,false);
        return new FotoMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FotoMascotaViewHolder fotoMascotaViewHolder, int position) {
        final Mascota mascota =mascotas.get(position);
        fotoMascotaViewHolder.fotoMascota.setImageResource(mascota.getFoto());
        fotoMascotaViewHolder.puntajeMascota.setText(Integer.toString(mascota.getPuntaje()));
        fotoMascotaViewHolder.huesoMascota.setImageResource(R.drawable.huesodorado);
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class FotoMascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView fotoMascota;
        private TextView puntajeMascota;
        private ImageView huesoMascota;

        public FotoMascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoMascota = (ImageView) itemView.findViewById(R.id.cvFotoFoto);
            puntajeMascota = (TextView) itemView.findViewById(R.id.cvFotoPuntaje);
            huesoMascota = (ImageView) itemView.findViewById(R.id.cvFotoFavorito);
        }
    }
}
