package com.example.alumno.myapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alumno.myapplication.MainActivity;
import com.example.alumno.myapplication.R;

public class LoginActivity extends AppCompatActivity {

    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent( LoginActivity.this, MainActivity.class);
                LoginActivity.this.startActivity(x);
            }
        });

    }
}
