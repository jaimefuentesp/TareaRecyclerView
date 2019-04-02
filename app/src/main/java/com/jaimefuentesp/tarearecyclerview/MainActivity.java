package com.jaimefuentesp.tarearecyclerview;


import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFloatingButton();

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.cvDetalleMascota);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void agregarFloatingButton(){
        FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.miFloatingActionButton);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Intent.ACTION_CAMERA_BUTTON));
                Toast.makeText(getApplicationContext(),"boton de camara",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.itemFavotito:
                    Intent intent = new Intent(this,ActivityFavoritos.class);
                    startActivity(intent);
                break;
            case R.id.itemPrueba:

                break;
        }
        return true;
    }

    public void inicializarAdaptador () {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas () {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.perrito,"Bobby",2,false));
        mascotas.add(new Mascota(R.drawable.perro1,"Scotty",3,true));
        mascotas.add(new Mascota(R.drawable.perro2,"Fido",10,false));
        mascotas.add(new Mascota(R.drawable.perro3,"Guau",10,false));
        mascotas.add(new Mascota(R.drawable.perro4,"James",10,true));
        mascotas.add(new Mascota(R.drawable.gato1,"Michi",10,false));
        mascotas.add(new Mascota(R.drawable.gato2,"Miau",10,false));
        mascotas.add(new Mascota(R.drawable.gato3,"Rata",10,true));
    }
}