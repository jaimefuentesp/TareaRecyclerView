package com.jaimefuentesp.tarearecyclerview.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jaimefuentesp.tarearecyclerview.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos (Context context) {
        super(context,ConstantesBaseDatos.DATABASE_NAME,null,ConstantesBaseDatos.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                            ConstantesBaseDatos.TABLE_MASCOTASS_ID      + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE   + " TEXT, " +
                            ConstantesBaseDatos.TABLE_MASCOTAS_PUNTAJE  + " INTEGER, " +
                            ConstantesBaseDatos.TABLE_MASCOTAS_FOTO     + " INTEGER" +
                            ")";
        db.execSQL(queryCrearTablaMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas () {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros =db.rawQuery(query,null);

        while (registros.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setPuntaje(registros.getInt(2));
            mascotaActual.setFoto(registros.getInt(3));
            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota (ContentValues contentValues) {
        SQLiteDatabase db = getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null,contentValues);
        db.close();
    }

}