package com.example.alumno.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.ls.LSException;

import java.util.List;

public class Adaptador extends BaseAdapter {

    Context contexto;
    List<Datos> ListaObjetos;

    public Adaptador(Context contexto, List<Datos> listaObjetos) {
        this.contexto = contexto;
        ListaObjetos = listaObjetos;
    }

    @Override
    public int getCount() {
        return ListaObjetos.size(); //Retorna la cantidad de la lista
    }

    @Override
    public Object getItem(int position) {
        return ListaObjetos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ListaObjetos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista=convertView;

        LayoutInflater inflate=LayoutInflater.from(contexto);
        vista=inflate.inflate(R.layout.itemlistview,null);
        ImageView Imagen=(ImageView) vista.findViewById(R.id.imageViewP);
        TextView Titulo = (TextView) vista.findViewById(R.id.textNombre);
        TextView Precio = (TextView) vista.findViewById(R.id.textPrecio);
        TextView Vendidos= (TextView) vista.findViewById(R.id.textVendidos);

        Titulo.setText(ListaObjetos.get(position).getTitulo().toString());
        Precio.setText(ListaObjetos.get(position).getPrecio().toString());
        Vendidos.setText(ListaObjetos.get(position).getVendidos().toString());
        Imagen.setImageResource(ListaObjetos.get(position).getImagen());

        return vista;


    }
}
