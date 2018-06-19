package com.example.eddyvalencia.myfitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;

public class ActivityDiario extends AppCompatActivity {
    private View btnDesayuno, btnAlmuerzo, btnComida, btnSnacks, btnEjercicios;
    private String tipoComida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diario);

        btnDesayuno = (Button) findViewById(R.id.bDesayuno);
        btnAlmuerzo = (Button) findViewById(R.id.bAlmuerzo);
        btnComida = (Button) findViewById(R.id.bComida);
        btnSnacks = (Button) findViewById(R.id.bSnacks);
        btnEjercicios = (Button) findViewById(R.id.bEjercicios);

        btnDesayuno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tipoComida = "Desayuno";
                registerForContextMenu(v);
                openContextMenu(v);


            }
        });

        btnAlmuerzo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tipoComida = "Almuerzo";
                registerForContextMenu(v);
                openContextMenu(v);

            }
        });

        btnComida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tipoComida = "Comida";
                registerForContextMenu(v);
                openContextMenu(v);

            }
        });

        btnSnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tipoComida = "Snacks";
                registerForContextMenu(v);
                openContextMenu(v);

            }
        });

        btnEjercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityDiario.this, ActivityListEjercicios.class);
                startActivity(intent);

            }
        });

    }

    //CONTEXT MENU, OPCIONES
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu_alimentos, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        Bundle miBundle = new Bundle();
        miBundle.putString("tipoComida", tipoComida);

        switch (item.getItemId()){
            case R.id.menu_alimentos:

                Intent intent = new Intent(ActivityDiario.this, ActivityListAlimentos.class);
                intent.putExtras(miBundle);
                startActivity(intent);

                return true;
            case R.id.menu_receta:
                Intent intent2 = new Intent(ActivityDiario.this, ActivityListRecetas.class);
                intent2.putExtras(miBundle);
                startActivity(intent2);

                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
