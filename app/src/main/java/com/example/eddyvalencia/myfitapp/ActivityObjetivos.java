package com.example.eddyvalencia.myfitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ActivityObjetivos extends AppCompatActivity {

    private View btnEditarMacron;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetivos);

        btnEditarMacron = (Button) findViewById(R.id.bEditar);

        btnEditarMacron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityObjetivos.this, ActivityEditMacronProteinas.class);
                startActivity(intent);

            }
        });
    }
}
