package com.jaimefuentesp.tarearecyclerview.adapter;

import android.app.Activity;
import android.content.ContentValues;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jaimefuentesp.tarearecyclerview.ActivityFavoritos;
import com.jaimefuentesp.tarearecyclerview.MainActivity;
import com.jaimefuentesp.tarearecyclerview.R;
import com.jaimefuentesp.tarearecyclerview.db.ConstantesBaseDatos;
import com.jaimefuentesp.tarearecyclerview.db.ConstructorMascotas;
import com.jaimefuentesp.tarearecyclerview.fragment.FragmentoInicio;
import com.jaimefuentesp.tarearecyclerview.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas=mascotas;
        this.activity=activity;
    }

    public MascotaAdaptador(ArrayList<Mascota> mascotas, ActivityFavoritos activity) {
        this.mascotas=mascotas;
        this.activity=activity;
    }

    @NonNull
    @Override
    public MascotaAdaptador.MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new MascotaViewHolder(v);
    }


    public void onBindViewHolder (MascotaViewHolder mascotaViewHolder,int position) {
        final Mascota mascota =mascotas.get(position);
        mascotaViewHolder.fotoMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.calificarMascota.setImageResource(R.drawable.huesoblanco);
        mascotaViewHolder.nombreMascota.setText(mascota.getNombre());
        mascotaViewHolder.puntajeMascota.setText(Integer.toString(mascota.getPuntaje()));
        if (mascota.isFavorito()==true) {
            mascotaViewHolder.favoritoMascota.setImageResource(R.drawable.huesodorado);
        } else {
            mascotaViewHolder.favoritoMascota.setImageResource(R.drawable.huesoblanco);
        }
        mascotaViewHolder.favoritoMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"Agregaste a favoritos a "+mascota.getNombre(),Toast.LENGTH_SHORT).show();
                ConstructorMascotas constructorMascotas= new ConstructorMascotas(activity);
                ContentValues contentValues = new ContentValues();
                contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE,mascota.getNombre());
                contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_PUNTAJE,mascota.getPuntaje());
                contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,mascota.getFoto());
                constructorMascotas.insertarMascota(contentValues);
                //constructorContactos.darLikeContacto(contacto);
                //contactoViewHolder.tvLikes.setText(String.valueOf(constructorContactos.obtenerLikesContacto(contacto))+" LIKES");
            }
        });
        mascotaViewHolder.calificarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"Botón puntuación, no implementado. La tarea es implementar el botón de favotiros de la derecha",Toast.LENGTH_SHORT).show();
            }
        });
        //mascotaViewHolder.favoritoMascota.setImageResource(mascota.getFoto());
    }

    public int getItemCount() {
        return mascotas.size();
        //return 5;
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView fotoMascota;
        private ImageButton calificarMascota;
        private TextView nombreMascota;
        private TextView puntajeMascota;
        private ImageButton favoritoMascota;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            fotoMascota = (ImageView) itemView.findViewById(R.id.cvFotoMascota);
            calificarMascota = (ImageButton) itemView.findViewById(R.id.cvIBCalificarMascota);
            nombreMascota = (TextView) itemView.findViewById(R.id.cvNombreMascota);
            puntajeMascota = (TextView) itemView.findViewById(R.id.cvPuntajeMascota);
            favoritoMascota = (ImageButton) itemView.findViewById(R.id.cvFavotitoMascota);
        }
    }
}
