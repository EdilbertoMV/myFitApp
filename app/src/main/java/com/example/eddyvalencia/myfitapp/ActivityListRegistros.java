package com.example.eddyvalencia.myfitapp;

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

import com.example.eddyvalencia.myfitapp.entidades.Alimento;
import com.example.eddyvalencia.myfitapp.entidades.Registros;
import com.example.eddyvalencia.myfitapp.utilidades.Utilidades;

import java.util.ArrayList;

public class ActivityListRegistros extends AppCompatActivity {

    private ListView registros;
    ConexionSqliteHelper conn;
    ArrayList<String> listaInformacion;
    ArrayList<Registros> listaRegistros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_registros);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        registros = (ListView) findViewById(R.id.lvListaRegistros);

        conn = new ConexionSqliteHelper(getApplicationContext(),"bd fitness",null,1);

        consultarListaAlimentos();

        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        registros.setAdapter(adaptador);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void consultarListaAlimentos() {

        SQLiteDatabase db = conn.getReadableDatabase();

        Registros registro = null;
        listaRegistros = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_REGISTROS, null);

        while (cursor.moveToNext()){

            registro=new Registros();
            registro.setId(cursor.getInt(0));
            registro.setFecha(cursor.getString(1));
            registro.setTipoComida(cursor.getString(2));
            registro.setIdComida(cursor.getString(3));

            listaRegistros.add(registro);

        }

        obtenerLista();
    }

    private void obtenerLista() {

        listaInformacion = new ArrayList<String>();

        for(int i=0; i<listaRegistros.size();i++){

            listaInformacion.add(listaRegistros.get(i).getFecha()+","+listaRegistros.get(i).getTipoComida()+" - "+listaRegistros.get(i).getIdComida());
        }
    }

}
