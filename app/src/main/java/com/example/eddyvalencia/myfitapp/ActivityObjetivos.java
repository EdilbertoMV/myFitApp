package com.example.eddyvalencia.myfitapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.eddyvalencia.myfitapp.utilidades.Utilidades;

public class ActivityObjetivos extends AppCompatActivity {

    private View btnEditarMacron;
    private EditText pesoInicial, pesoActual, pesoDeseado, edad, estatura;
    private Switch switchRA, switchSM;
    private String aumentarReducir, semanaMes;
    private Spinner nivelActividad;
    private View bCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetivos);

        switchRA = (Switch) findViewById(R.id.switchReducirAumentar);
        switchSM = (Switch) findViewById(R.id.switchPorSemana);
        nivelActividad = (Spinner) findViewById(R.id.spinnerNivelActividad);
        pesoInicial = (EditText) findViewById(R.id.etPesoInicial);
        pesoActual = (EditText) findViewById(R.id.etPesoActual);
        pesoDeseado = (EditText) findViewById(R.id.etPesoDeseado);
        edad = (EditText) findViewById(R.id.etEdad);
        estatura = (EditText) findViewById(R.id.etEstatura);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerNivelActividad, android.R.layout.simple_spinner_item);

        nivelActividad.setAdapter(adapter);

        btnEditarMacron = (Button) findViewById(R.id.bEditar);

        btnEditarMacron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityObjetivos.this, ActivityEditMacronProteinas.class);

                Bundle miBundle = new Bundle();
                miBundle.putString("pesoInicial", pesoInicial.getText().toString());
                miBundle.putString("pesoActual", pesoActual.getText().toString());
                miBundle.putString("pesoDeseado", pesoDeseado.getText().toString());
                miBundle.putString("edad", edad.getText().toString());
                miBundle.putString("estatura", estatura.getText().toString());
                miBundle.putString("nivelActividad", nivelActividad.getSelectedItem().toString());
                miBundle.putString("aumentarReducir", aumentarReducir);
                miBundle.putString("semanaMes", semanaMes);

                intent.putExtras(miBundle);
                startActivity(intent);

            }
        });

    }

    public void onclick(View view) {

        if(view.getId()==R.id.switchReducirAumentar){
            if(switchRA.isChecked()){
                aumentarReducir = "Reducir";
            }else{
                aumentarReducir = "Aumentar";
            }

        }

        if(view.getId()==R.id.switchPorSemana){
            if(switchSM.isChecked()){
                semanaMes = "Semana";

            }else{
                semanaMes = "Mes";
            }
        }
    }
}
