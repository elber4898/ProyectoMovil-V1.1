package com.example.alumno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.alumno.myapplication.helpers.Callback;
import com.example.alumno.myapplication.helpers.MonitorObservable;
import com.example.alumno.myapplication.helpers.ObserverBind;
import com.example.alumno.myapplication.models.Client;

import java.nio.channels.ClosedByInterruptException;
import java.util.Observable;

public class MainActivity extends AppCompatActivity {

    Button btnIngresar;

    //-----------------
    MonitorObservable monitorObservable;
    ObserverBind observerBind;
    Client clientObject;

    //-----------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-------------------------
        clientObject=new Client();
        clientObject.setYear_old(19);

        observerBind=new ObserverBind();

        monitorObservable=new MonitorObservable(clientObject);
        observerBind.setCallback(new Callback(){
            @Override
            public void doThis(Observable o, Object x) {
                //Todo lo que yo quiera
                Log.v("bichito", "xxx");
                Toast.makeText(MainActivity.this, clientObject.getYear_old()+"", Toast.LENGTH_SHORT).show();
            }
        });
        monitorObservable.addObserver(observerBind);


        btnIngresar=(Button)findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clientObject.setYear_old(clientObject.getYear_old()+1);
                monitorObservable.setWachedValue(clientObject);
            }
        });

//-------------------------

       // final Button btnIngresar = (Button) findViewById(R.id.btnIngresar);
        // btnIngresar.setOnClickListener(new View.OnClickListener() {
        //  @Override
        //  public void onClick(View v) {
        //      Intent x = new Intent( MainActivity.this, ProductosVActivity.class);
        //      MainActivity.this.startActivity(x);


        //      }
    // });

    }
}
