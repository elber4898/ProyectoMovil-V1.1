package com.example.alumno.myapplication;

import java.io.Serializable;

public class Datos implements Serializable {
    private int Id;
    private String Titulo;
    private String Precio;
    private String Vendidos;
    private int Imagen;

    public Datos(int id, String titulo, String precio, String vendidos, int imagen) {
        Id = id;
        Titulo = titulo;
        Precio = precio;
        Vendidos = vendidos;
        Imagen = imagen;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getVendidos() {
        return Vendidos;
    }

    public void setVendidos(String vendidos) {
        Vendidos = vendidos;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }
}
