package com.example.alumno.myapplication;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.alumno.myapplication.helpers.QueueUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Datos implements Serializable {
    private int Id;
    private String Titulo;
    private String Precio;
    private String Vendidos;
    private int Imagen;
    private String Img;

    public Datos(int id, String titulo, String precio, String vendidos, int imagen) {
        Id = id;
        Titulo = titulo;
        Precio = precio;
        Vendidos = vendidos;
        Imagen = imagen;
    }

    public Datos(int id, String titulo, String precio, String vendidos, String _img) {
        Id = id;
        Titulo = titulo;
        Precio = precio;
        Vendidos = vendidos;
        Img = _img;
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

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public static void injectProductsFromCloud(final QueueUtils.QueueObject o,
                                               final ArrayList<Datos> products,
                                               final ProductosVActivity _interface
                                               ) {
        String url = "https://reqres.in/api/products";
        url = "http://rwieruch-node-express-server-rest-api-5.glitch.me/messages";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        if (response.has("data")) {

                            try {
                                JSONArray list = response.getJSONArray("data");
                                for (int i=0; i < list.length(); i++) {
                                    JSONObject o = list.getJSONObject(i);
                                    products.add(new Datos(o.getInt("Id"),
                                            o.getString("Titulo"),
                                            o.getString("Precio"),
                                            o.getString("Vendidos"),
                                            o.getString("Imagen")));
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                           _interface.refreshList();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        int b = 2;
                        b += 1;

                    }
                });
        o.addToRequestQueue(jsonObjectRequest);
    }
}

