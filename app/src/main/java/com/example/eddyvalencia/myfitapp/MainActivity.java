package com.example.eddyvalencia.myfitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private View btnAlimentos, btnObjetivos, btnReportes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CONEXION SQLITE
        ConexionSqliteHelper conn = new ConexionSqliteHelper(getApplicationContext(),"bd fitness",null,1);

        /////////////////
        btnAlimentos = (ImageButton) findViewById(R.id.bDiario);
        btnObjetivos = (ImageButton) findViewById(R.id.bObjetivos);
        btnReportes = (ImageButton) findViewById(R.id.bReportes);

        btnAlimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityDiario.class);
                startActivity(intent);
            }
        });

        btnObjetivos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityObjetivos.class);
                startActivity(intent);
            }
        });

    }



}
