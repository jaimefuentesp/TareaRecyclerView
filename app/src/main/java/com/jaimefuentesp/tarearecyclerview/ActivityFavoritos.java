package com.jaimefuentesp.tarearecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import java.util.ArrayList;

public class ActivityFavoritos extends AppCompatActivity {

    ArrayList<Mascota> mascotasFavorito;
    private RecyclerView listaMascotasFavorito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        //this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotasFavorito = (RecyclerView) findViewById(R.id.cvFavoritosMascota);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotasFavorito.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador () {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotasFavorito,this);
        listaMascotasFavorito.setAdapter(adaptador);
    }

    public void inicializarListaMascotas () {
        mascotasFavorito = new ArrayList<Mascota>();

        mascotasFavorito.add(new Mascota(R.drawable.perro1,"Scotty",3,true));
        mascotasFavorito.add(new Mascota(R.drawable.perro4,"James",10,true));
        mascotasFavorito.add(new Mascota(R.drawable.gato3,"Rata",5,true));
        mascotasFavorito.add(new Mascota(R.drawable.gato2,"Miau",10,false));
        mascotasFavorito.add(new Mascota(R.drawable.gato3,"Rata",10,true));
    }


}
