package com.example.eddyvalencia.myfitapp.utilidades;

public class Utilidades {

    public static final String TABLA_ALIMENTO = "alimento";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_TIPO_CANTIDAD = "tipoCantidad";
    public static final String CAMPO_CANTIDAD = "cantidad";
    public static final String CAMPO_CALORIAS = "calorias";
    public static final String CAMPO_CARBOHIDRATOS = "carbohidratos";
    public static final String CAMPO_GRASAS = "grasas";

    public static final String TABLA_RECETA = "alimento";
    public static final String CAMPO_PREPARACION = "grasas";

    public static final String CREAR_TABLA_ALIMENTO = "CREATE TABLE" + TABLA_ALIMENTO + " ("+ CAMPO_ID +" INTEGER, "+ CAMPO_NOMBRE +" TEXT, "+ CAMPO_TIPO_CANTIDAD +" TEXT, "+ CAMPO_CANTIDAD +" INTEGER, "+ CAMPO_CALORIAS +" INTEGER, "+ CAMPO_CARBOHIDRATOS +" INTEGER, "+ CAMPO_GRASAS +" INTEGER)";
    public static final String CREAR_TABLA_RECETA = "CREATE TABLE "+ TABLA_RECETA +" ("+ CAMPO_ID +" INTEGER, "+ CAMPO_NOMBRE +" TEXT, "+ CAMPO_PREPARACION +" TEXT)";

}
