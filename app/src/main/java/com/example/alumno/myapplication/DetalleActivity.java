package com.example.alumno.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {
    ImageView foto;
    TextView Titulo;
    TextView Precio;
    TextView Vendidos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        foto = (ImageView) findViewById(R.id.ImageFoto);
        Titulo = (TextView) findViewById(R.id.textDT);
        Precio = (TextView) findViewById(R.id.textDP);
        Vendidos = (TextView) findViewById(R.id.textDV);

        Datos obj = (Datos) getIntent().getExtras().getSerializable("objeto");

        Titulo.setText(obj.getTitulo());
        Precio.setText(obj.getPrecio());
        Vendidos.setText(obj.getVendidos());
        foto.setImageResource(obj.getImagen());

    }
}
