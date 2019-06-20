package com.example.alumno.myapplication.presenters;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.alumno.myapplication.MainActivity;
import com.example.alumno.myapplication.helpers.Callback;
import com.example.alumno.myapplication.helpers.MonitorObservable;
import com.example.alumno.myapplication.helpers.ObserverBind;
import com.example.alumno.myapplication.models.Client;

import java.util.Observable;

public class MainPresenter {
    public MonitorObservable monitorObservable;
    ObserverBind observerBind;
    public void MainPresenter(final Context _context, final Client clientObject){

        monitorObservable=new MonitorObservable(clientObject);
        observerBind=new ObserverBind();
        observerBind.setCallback(new Callback(){
            @Override
            public void doThis(Observable o, Object x) {
                //Todo lo que yo quiera
                Log.v("bichito", "xxx");
                Toast.makeText(_context, clientObject.getYear_old()+"", Toast.LENGTH_SHORT).show();
            }
        });
        monitorObservable.addObserver(observerBind);
    }
}
