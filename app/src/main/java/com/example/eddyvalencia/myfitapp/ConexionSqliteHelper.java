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

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS alimentos");
        db.execSQL("DROP TABLE IF EXISTS recetas");
        onCreate(db);
    }
}
