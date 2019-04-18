package com.jaimefuentesp.tarearecyclerview.db;

import android.content.ContentValues;
import android.content.Context;

import com.jaimefuentesp.tarearecyclerview.R;
import com.jaimefuentesp.tarearecyclerview.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;


    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos () {

        ArrayList mascotas = new ArrayList<Mascota>();
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
        return mascotas;
    }

    public ArrayList<Mascota> obtenerFavoritos () {
        BaseDatos db = new BaseDatos(context);
        ArrayList<Mascota> mascotas = db.obtenerTodasLasMascotas();
        if (mascotas.size()<6) {
            return mascotas;
        }
        else {
            int cantidad=mascotas.size();
            int maximo=1;
            ArrayList<Mascota> mascotasFinal = new ArrayList<>();
            while (cantidad>0 && maximo<6) {
                mascotasFinal.add(mascotas.get(cantidad-1));
                cantidad=cantidad-1;
                maximo=maximo+1;
            }
            return mascotasFinal;
        }
        /*
        ArrayList mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.perro1,"Scotty",3,true));
        mascotas.add(new Mascota(R.drawable.perro4,"James",10,true));
        mascotas.add(new Mascota(R.drawable.gato3,"Rata",5,true));
        mascotas.add(new Mascota(R.drawable.gato2,"Miau",10,false));
        mascotas.add(new Mascota(R.drawable.gato3,"Rata",10,true));
        return mascotas;*/
    }

    public void insertarMascota (ContentValues contentValues) {
        BaseDatos db = new BaseDatos(context);
        db.insertarMascota(contentValues);
    }

}
