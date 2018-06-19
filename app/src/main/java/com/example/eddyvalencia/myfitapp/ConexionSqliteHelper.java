package com.example.eddyvalencia.myfitapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.eddyvalencia.myfitapp.utilidades.Utilidades;

public class ConexionSqliteHelper extends SQLiteOpenHelper {

    public ConexionSqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_ALIMENTO);
        db.execSQL(Utilidades.CREAR_TABLA_RECETA);
        db.execSQL(Utilidades.CREAR_TABLA_EJERCICIO);
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
        db.execSQL(Utilidades.CREAR_TABLA_REGISTRO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS alimentos");
        db.execSQL("DROP TABLE IF EXISTS recetas");
        db.execSQL("DROP TABLE IF EXISTS ejercicios");
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS registros");
        onCreate(db);
    }
}
