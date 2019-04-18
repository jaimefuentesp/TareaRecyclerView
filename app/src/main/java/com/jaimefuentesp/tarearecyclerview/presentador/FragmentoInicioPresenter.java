package com.jaimefuentesp.tarearecyclerview.presentador;

import android.content.Context;
import android.view.View;

import com.jaimefuentesp.tarearecyclerview.db.ConstructorMascotas;
import com.jaimefuentesp.tarearecyclerview.fragment.IFragmentoInicioView;
import com.jaimefuentesp.tarearecyclerview.pojo.Mascota;

import java.util.ArrayList;

public class FragmentoInicioPresenter implements IFragmentoInicioPresenter {

    IFragmentoInicioView iFragmentoInicioView;
    Context context;
    ArrayList<Mascota> mascotas;
    private ConstructorMascotas constructorMascotas;

    public FragmentoInicioPresenter(IFragmentoInicioView iFragmentoInicioView,Context context) {
        this.iFragmentoInicioView=iFragmentoInicioView;
        this.context=context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas =new ConstructorMascotas(context);
        mascotas=constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iFragmentoInicioView.inicializarAdaptadorRV(iFragmentoInicioView.crearAdaptador(mascotas));
        iFragmentoInicioView.generarLinearLayoutVertical();
    }

    public void agregarFavorito(View view) {

    }
}
