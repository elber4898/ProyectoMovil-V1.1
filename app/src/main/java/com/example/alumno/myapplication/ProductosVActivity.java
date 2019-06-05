package com.example.alumno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProductosVActivity extends AppCompatActivity {

    Button btnPrenda1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_v);

        Button btnPrenda1 = (Button) findViewById(R.id.btnPrenda1);
        btnPrenda1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent( ProductosVActivity.this, DetalleActivity.class);
                ProductosVActivity.this.startActivity(x);
            }
        });

    }
}
