package com.example.alumno.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class ListProductsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Llamar a un Activity
        Intent intent = new Intent(getActivity(), ProductosVActivity.class);
        getActivity().startActivity(intent);
        //

        return inflater.inflate(R.layout.fragment_list_products, container, false);
    }
}
