package com.example.eddyvalencia.myfitapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.eddyvalencia.myfitapp.utilidades.Utilidades;

public class ActivityEditMacronProteinas extends AppCompatActivity {

    private EditText calorias, carbohidratos, proteinas, grasas;
    private String tipo, pesoInicial, pesoActual, pesoDeseado, edad, estatura, nivelActividad, aumentarReducir, semanaMes;
    private View bGuardar;
    private CheckBox gramos, porcentaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_macron_proteinas);

        calorias = (EditText) findViewById(R.id.etCaloriasGramos);
        carbohidratos = (EditText) findViewById(R.id.etCarbohidratos);
        proteinas = (EditText) findViewById(R.id.etProteinas);
        grasas = (EditText) findViewById(R.id.etGrasas);
        gramos = (CheckBox) findViewById(R.id.cbGramos);
        porcentaje = (CheckBox) findViewById(R.id.cbPorcentaje);

        Bundle miBundle = this.getIntent().getExtras();

        if(miBundle!=null){

            pesoInicial = miBundle.getString("pesoInicial");
            pesoActual = miBundle.getString("pesoActual");
            pesoDeseado = miBundle.getString("pesoDeseado");
            edad = miBundle.getString("edad");
            estatura = miBundle.getString("estatura");
            nivelActividad = miBundle.getString("nivelActividad");
            aumentarReducir = miBundle.getString("aumentarReducir");
            semanaMes = miBundle.getString("semanaMes");
        }

        if(gramos.isChecked()){
            tipo = "Gramos";
            porcentaje.setClickable(false);
        }else if(porcentaje.isChecked()){
            tipo = "Porcentaje";
            gramos.setClickable(false);
        }else{
            tipo = "Gramos";
        }

        bGuardar = (Button) findViewById(R.id.bGuardar);

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConexionSqliteHelper conn = new ConexionSqliteHelper(getApplicationContext(),"bd fitness",null,1);

                SQLiteDatabase db = conn.getWritableDatabase();

                String insert = "INSERT INTO " + Utilidades.TABLA_USUARIO
                        + " (" + Utilidades.CAMPO_ID + ", "
                        + Utilidades.CAMPO_PESO_INICIAL + ", "
                        + Utilidades.CAMPO_PESO_ACTUAL + ", "
                        + Utilidades.CAMPO_PESO_DESEADO + ", "
                        + Utilidades.CAMPO_EDAD + ", "
                        + Utilidades.CAMPO_ESTATURA + ", "
                        + Utilidades.CAMPO_REDUCIR_AUMENTAR + ", "
                        + Utilidades.CAMPO_SEMANA_MES + ", "
                        + Utilidades.CAMPO_NIVEL_ACTIVIDAD + ", "
                        + Utilidades.CAMPO_CALORIAS + ", "
                        + Utilidades.CAMPO_CARBOHIDRATOS + ", "
                        + Utilidades.CAMPO_PROTEINAS + ", "
                        + Utilidades.CAMPO_GRASAS + ", "
                        + Utilidades.CAMPO_TIPO + ") "
                        +"VALUES (null, "+pesoInicial+","+pesoActual
                        +","+pesoDeseado+","+edad+","+estatura+",'"+aumentarReducir+"','"+semanaMes+"','"+nivelActividad
                        +"',"+calorias.getText().toString()+","+carbohidratos.getText().toString()
                        +","+proteinas.getText().toString()+","+grasas.getText().toString()+",'"+ tipo +"')";

                db.execSQL(insert);
                db.close();

                Snackbar.make(v, "SE AGREGARON TUS OBJETIVOS", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }
}
