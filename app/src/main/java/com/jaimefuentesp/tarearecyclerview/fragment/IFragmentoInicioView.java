package com.jaimefuentesp.tarearecyclerview.fragment;

import com.jaimefuentesp.tarearecyclerview.adapter.MascotaAdaptador;
import com.jaimefuentesp.tarearecyclerview.pojo.Mascota;

import java.util.ArrayList;

public interface IFragmentoInicioView {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> contactos);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
