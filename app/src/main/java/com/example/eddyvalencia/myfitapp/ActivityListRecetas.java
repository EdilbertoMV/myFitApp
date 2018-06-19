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

import com.example.eddyvalencia.myfitapp.entidades.Alimento;
import com.example.eddyvalencia.myfitapp.utilidades.Utilidades;

import java.util.ArrayList;

public class ActivityListRecetas extends AppCompatActivity {

    private ListView alimentos;
    ConexionSqliteHelper conn;
    ArrayList<String> listaInformacion;
    ArrayList<Alimento> listaAlimentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_recetas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        alimentos = (ListView) findViewById(R.id.lvAlimentos);

        conn = new ConexionSqliteHelper(getApplicationContext(),"bd fitness",null,1);

        consultarListaAlimentos();

        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        alimentos.setAdapter(adaptador);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityListRecetas.this, ActivityCreateReceta.class);
                startActivity(intent);
            }
        });
    }

    private void consultarListaAlimentos() {

        SQLiteDatabase db = conn.getReadableDatabase();

        Alimento alimento = null;
        listaAlimentos = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_ALIMENTO, null);

        while (cursor.moveToNext()){

            alimento=new Alimento();
            alimento.setId(cursor.getInt(0));
            alimento.setNombre(cursor.getString(1));
            alimento.setTipoCantidad(cursor.getString(2));
            alimento.setCantidad(cursor.getInt(3));
            alimento.setCalorias(cursor.getInt(4));
            alimento.setCarbohidratos(cursor.getInt(5));
            alimento.setGrasas(cursor.getInt(6));

            listaAlimentos.add(alimento);

        }

        obtenerLista();
    }

    private void obtenerLista() {

        listaInformacion = new ArrayList<String>();

        for(int i=0; i<listaAlimentos.size();i++){

            listaInformacion.add(listaAlimentos.get(i).getId()+" - "
                    +listaAlimentos.get(i).getNombre());
        }
    }

}
