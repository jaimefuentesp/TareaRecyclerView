package com.jaimefuentesp.tarearecyclerview.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jaimefuentesp.tarearecyclerview.R;
import com.jaimefuentesp.tarearecyclerview.adapter.FotoAdapter;
import com.jaimefuentesp.tarearecyclerview.adapter.MascotaAdaptador;
import com.jaimefuentesp.tarearecyclerview.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoMascota extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public FragmentoMascota() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmento_mascota, container, false);

        FloatingActionButton miFAB = (FloatingActionButton) v.findViewById(R.id.miFloatingActionButton);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Intent.ACTION_CAMERA_BUTTON));
                Toast.makeText(getContext(),"boton de camara",Toast.LENGTH_SHORT).show();
            }
        });

        listaMascotas = (RecyclerView) v.findViewById(R.id.cvFotoMascota);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);

        listaMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador () {
        FotoAdapter adaptador = new FotoAdapter(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas () {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.perrito,"Bobby",2,false));
        mascotas.add(new Mascota(R.drawable.perro1,"Scotty",3,true));
        mascotas.add(new Mascota(R.drawable.perro2,"Fido",10,false));
        mascotas.add(new Mascota(R.drawable.perro3,"Guau",10,false));
        mascotas.add(new Mascota(R.drawable.perro4,"James",10,true));
        mascotas.add(new Mascota(R.drawable.perrito,"Bobby",2,false));
        mascotas.add(new Mascota(R.drawable.perro1,"Scotty",3,true));
        mascotas.add(new Mascota(R.drawable.perro2,"Fido",10,false));
        mascotas.add(new Mascota(R.drawable.perro3,"Guau",10,false));
        mascotas.add(new Mascota(R.drawable.perro4,"James",10,true));
        mascotas.add(new Mascota(R.drawable.perrito,"Bobby",2,false));
        mascotas.add(new Mascota(R.drawable.perro1,"Scotty",3,true));
        mascotas.add(new Mascota(R.drawable.perro2,"Fido",10,false));
        mascotas.add(new Mascota(R.drawable.perro3,"Guau",10,false));
        mascotas.add(new Mascota(R.drawable.perro4,"James",10,true));
    }
}
