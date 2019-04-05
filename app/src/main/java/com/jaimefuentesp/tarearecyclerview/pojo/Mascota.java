package com.jaimefuentesp.tarearecyclerview.pojo;

public class Mascota {
    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return Puntaje;
    }

    public void setPuntaje(int puntaje) {
        Puntaje = puntaje;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    private int foto;
    private String nombre;
    private int Puntaje;
    private boolean favorito;

    public Mascota(int foto, String nombre, int puntaje, boolean favorito) {
        this.foto = foto;
        this.nombre = nombre;
        Puntaje = puntaje;
        this.favorito = favorito;
    }


}
