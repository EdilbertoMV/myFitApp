package com.example.eddyvalencia.myfitapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.eddyvalencia.myfitapp.entidades.Ejercicio;
import com.example.eddyvalencia.myfitapp.utilidades.Utilidades;

import java.util.ArrayList;

public class ActivityListEjercicios extends AppCompatActivity {

    private ListView ejercicios;
    ConexionSqliteHelper conn;
    ArrayList<String> listaInformacion;
    ArrayList<Ejercicio> listaEjercicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ejercicios);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ejercicios = (ListView) findViewById(R.id.lvEjercicios);

        conn = new ConexionSqliteHelper(getApplicationContext(),"bd fitness",null,1);

        consultarListaEjercicios();

        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        ejercicios.setAdapter(adaptador);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityListEjercicios.this, ActivityCreateEjercicios.class);
                startActivity(intent);
            }
        });
    }

    private void consultarListaEjercicios() {

        SQLiteDatabase db = conn.getReadableDatabase();

        Ejercicio ejercicio = null;
        listaEjercicios = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_EJERCICIO, null);

        while (cursor.moveToNext()){

            ejercicio=new Ejercicio();
            ejercicio.setId(cursor.getInt(0));
            ejercicio.setNombre(cursor.getString(1));
            ejercicio.setDescripcion(cursor.getString(2));
            ejercicio.setCaloriasPerdidas(cursor.getInt(3));
            listaEjercicios.add(ejercicio);

        }

        obtenerLista();
    }

    private void obtenerLista() {

        listaInformacion = new ArrayList<String>();

        for(int i=0; i<listaEjercicios.size();i++){

            listaInformacion.add(listaEjercicios.get(i).getId()+" - "
                    +listaEjercicios.get(i).getNombre());
        }
    }

}
