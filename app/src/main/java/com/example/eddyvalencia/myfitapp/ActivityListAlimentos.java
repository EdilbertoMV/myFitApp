package com.example.eddyvalencia.myfitapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eddyvalencia.myfitapp.entidades.Alimento;
import com.example.eddyvalencia.myfitapp.utilidades.Utilidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ActivityListAlimentos extends AppCompatActivity {

    private ListView alimentos;
    ConexionSqliteHelper conn;
    ArrayList<String> listaInformacion;
    ArrayList<Alimento> listaAlimentos;
    private String tipoComida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_alimentos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();

        String fecha = dateFormat.format(date);

        alimentos = (ListView) findViewById(R.id.lvAlimentos);

        Bundle miBundle = this.getIntent().getExtras();

        if(miBundle!=null){

            tipoComida = miBundle.getString("tipoComida");
        }

        conn = new ConexionSqliteHelper(getApplicationContext(),"bd fitness",null,1);

        consultarListaAlimentos();

        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        alimentos.setAdapter(adaptador);


        alimentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //AQUI DEBE IR EL CONETEXTMENU PARA AGREGAR UN REGISTRO DEBE SER DE DOS OPCIONES PREGUNTAR SI SE QUIERE AGREGAR
                //EL ALIMENTO O NO, AL AGREGARSE OBVIAMENTE DEBES CREAR UNA CONSULTA SQL PARA AGREGAR EL REGISTRO A LA TABLA REGISTROS

                registerForContextMenu(view);
                openContextMenu(view);

                Toast.makeText(parent.getContext(),"SELECCIONASTE: "
                        +parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ActivityListAlimentos.this, ActivityCreateAlimento.class);
                startActivity(intent);
                finish();
            }
        });


    }

    //CONTEXT MENU, OPCIONES
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu_registrar, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        Bundle miBundle = new Bundle();
        miBundle.putString("tipoComida", tipoComida);

        switch (item.getItemId()){
            case R.id.menu_registrar:

                finish();

                return true;
            case R.id.menu_no_registrar:

                closeContextMenu();

                return true;
            default:
                return super.onContextItemSelected(item);
        }
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

            listaInformacion.add(listaAlimentos.get(i).getNombre());
        }
    }

}
