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

import com.example.eddyvalencia.myfitapp.utilidades.Utilidades;

public class ActivityCreateAlimento extends AppCompatActivity {

    private EditText nombre, cantidad, calorias, carbohidratos, grasas;
    private View bCancelar, bGuardar;
    private Spinner tipoCantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_alimento);

        nombre = (EditText) findViewById(R.id.etNombreAlimento);
        tipoCantidad = (Spinner) findViewById(R.id.spinnerTipoCantidad);
        cantidad = (EditText) findViewById(R.id.etCantidad);
        calorias = (EditText) findViewById(R.id.etCalorias);
        carbohidratos = (EditText) findViewById(R.id.etCarbohidratos);
        grasas = (EditText) findViewById(R.id.etGrasas);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerTipoCantidad, android.R.layout.simple_spinner_item);

        tipoCantidad.setAdapter(adapter);

        bGuardar = (Button) findViewById(R.id.bGuardar);

        bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConexionSqliteHelper conn = new ConexionSqliteHelper(getApplicationContext(),"bd alimentos",null,1);

                SQLiteDatabase db = conn.getWritableDatabase();

                String insert = "INSERT INTO" + Utilidades.TABLA_ALIMENTO
                        + " (" + Utilidades.CAMPO_ID + ", "
                        +" (" + Utilidades.CAMPO_NOMBRE + ", "
                        +" (" + Utilidades.CAMPO_TIPO_CANTIDAD + ", "
                        +" (" + Utilidades.CAMPO_CANTIDAD + ", "
                        +" (" + Utilidades.CAMPO_CALORIAS + ", "
                        +" (" + Utilidades.CAMPO_CARBOHIDRATOS + ", "
                        +" (" + Utilidades.CAMPO_GRASAS + ") "
                        +"values ( null, '"+nombre.getText().toString()+"','"+tipoCantidad.getSelectedItem().toString()
                        +"','"+cantidad.getText().toString()+"','"+calorias.getText().toString()
                        +"','"+carbohidratos.getText().toString()+"','"+grasas.getText().toString()+"')";

                db.execSQL(insert);
                db.close();
            }
        });
    }
}
