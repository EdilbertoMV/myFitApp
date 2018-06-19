package com.example.eddyvalencia.myfitapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.eddyvalencia.myfitapp.utilidades.Utilidades;

public class ActivityCreateEjercicios extends AppCompatActivity {

    private EditText nombre, caloriasPerdidas, descripcion;
    private View bCancelar, bGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_ejercicios);
        nombre = (EditText) findViewById(R.id.etNombreEjercicio);
        descripcion = (EditText) findViewById(R.id.etDescripcion);
        caloriasPerdidas = (EditText) findViewById(R.id.etCaloriasPerdidas);

        bGuardar = (Button) findViewById(R.id.bGuardar);

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConexionSqliteHelper conn = new ConexionSqliteHelper(getApplicationContext(),"bd fitness",null,1);

                SQLiteDatabase db = conn.getWritableDatabase();

                String insert = "INSERT INTO " + Utilidades.TABLA_EJERCICIO
                        + " (" + Utilidades.CAMPO_ID + ", "
                        + Utilidades.CAMPO_NOMBRE + ", "
                        + Utilidades.CAMPO_DESCRIPCION + ", "
                        + Utilidades.CAMPO_CALORIAS_PERDIDAS + ") "
                        +"VALUES (null, '"+nombre.getText().toString()+"','"+descripcion.getText().toString()
                        +"', "+caloriasPerdidas.getText().toString() + ")";

                db.execSQL(insert);
                db.close();
            }
        });
    }


}
