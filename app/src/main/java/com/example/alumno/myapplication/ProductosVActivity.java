package com.example.alumno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductosVActivity extends AppCompatActivity {

    ListView ListaDatos;
    ArrayList<Datos> List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_v);

        ListaDatos=(ListView) findViewById(R.id.lstDatos);
        List=new ArrayList<Datos>();

        List.add(new Datos(1, "RENZOFERRINI", "S/. 89.90", "VENDIDOS = 5", R.drawable.chompa));
        List.add(new Datos(2, "SSCOLET", "S/. 79.90", "VENDIDOS = 5", R.drawable.chompa2));
        List.add(new Datos(3, "FUGGART", "S/. 99.90", "VENDIDOS = 9", R.drawable.chompa5));
        List.add(new Datos(4, "ANNARAYNT", "S/. 89.90", "VENDIDOS = 6", R.drawable.chompa6));
        List.add(new Datos(5, "Van Heusen", "S/. 79.50", "VENDIDOS = 16", R.drawable.var1o));
        List.add(new Datos(6, "Cremallera Abrigo", "S/. 108.00", "VENDIDOS = 10", R.drawable.var2o));
        List.add(new Datos(7, "Cuello Grueso Abrigo", "S/. 111.00", "VENDIDOS = 15", R.drawable.var3o));
        List.add(new Datos(8, "Cremallera", "S/. 89.90", "VENDIDOS = 6", R.drawable.var4o));
        List.add(new Datos(9, "Cardigans ", "S/. 138.00", "VENDIDOS = 6", R.drawable.var5o));

        Adaptador miadaptador=new Adaptador(getApplicationContext(),List);

        ListaDatos.setAdapter(miadaptador);

        ListaDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Datos obj = (Datos) parent.getItemAtPosition(position);

               Intent paso = new Intent(getApplicationContext(), DetalleActivity.class);
               paso.putExtra("objeto", (Serializable) obj);
               startActivity(paso);
            }
        });

    }
}
