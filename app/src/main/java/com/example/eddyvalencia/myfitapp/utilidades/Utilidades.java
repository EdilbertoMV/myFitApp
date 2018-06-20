package com.example.eddyvalencia.myfitapp.utilidades;

public class Utilidades {

    public static final String TABLA_ALIMENTO = "alimentos";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_TIPO_CANTIDAD = "tipoCantidad";
    public static final String CAMPO_CANTIDAD = "cantidad";
    public static final String CAMPO_CALORIAS = "calorias";
    public static final String CAMPO_CARBOHIDRATOS = "carbohidratos";
    public static final String CAMPO_GRASAS = "grasas";

    public static final String TABLA_RECETA = "recetas";
    public static final String CAMPO_PREPARACION = "preparacion";

    public static final String TABLA_EJERCICIO = "ejercicios";
    public static final String CAMPO_DESCRIPCION = "descripcion";
    public static final String CAMPO_CALORIAS_PERDIDAS = "caloriasPerdidas";

    public static final String TABLA_USUARIO = "usuarios";
    public static final String CAMPO_PESO_INICIAL = "pesoInicial";
    public static final String CAMPO_PESO_DESEADO = "pesoDeseado";
    public static final String CAMPO_PESO_ACTUAL = "pesoActual";
    public static final String CAMPO_EDAD = "edad";
    public static final String CAMPO_ESTATURA = "estatura";
    public static final String CAMPO_REDUCIR_AUMENTAR = "reducirAumentar";
    public static final String CAMPO_SEMANA_MES = "semanaMes";
    public static final String CAMPO_NIVEL_ACTIVIDAD = "nivelActividad";
    public static final String CAMPO_PROTEINAS = "proteinas";
    public static final String CAMPO_TIPO = "tipoGramosPorcentaje";

    public static final String TABLA_REGISTROS = "registros";
    public static final String CAMPO_FECHA = "fecha";
    public static final String CAMPO_TIPO_COMIDA = "tipoComida";
    public static final String CAMPO_ID_COMIDA = "idComida";

    public static final String CREAR_TABLA_ALIMENTO = "CREATE TABLE " + TABLA_ALIMENTO + " ("+ CAMPO_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ CAMPO_NOMBRE +" TEXT, "+ CAMPO_TIPO_CANTIDAD +" TEXT, "+ CAMPO_CANTIDAD +" INTEGER, "+ CAMPO_CALORIAS +" INTEGER, "+ CAMPO_CARBOHIDRATOS +" INTEGER, "+ CAMPO_GRASAS +" INTEGER)";
    public static final String CREAR_TABLA_RECETA = "CREATE TABLE "+ TABLA_RECETA +" ("+ CAMPO_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ CAMPO_NOMBRE +" TEXT, "+ CAMPO_PREPARACION +" TEXT)";
    public static final String CREAR_TABLA_EJERCICIO = "CREATE TABLE "+ TABLA_EJERCICIO +" ("+ CAMPO_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ CAMPO_NOMBRE +" TEXT, "+ CAMPO_DESCRIPCION +" TEXT, "+ CAMPO_CALORIAS_PERDIDAS +" INTEGER)";
    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+ TABLA_USUARIO +" ("+ CAMPO_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ CAMPO_PESO_INICIAL +" INTEGER, "+ CAMPO_PESO_ACTUAL +" INTEGER, "+ CAMPO_PESO_DESEADO +" INTEGER, "
            + CAMPO_EDAD +" INTEGER, " + CAMPO_ESTATURA +" INTEGER, "+ CAMPO_REDUCIR_AUMENTAR +" TEXT, "+ CAMPO_SEMANA_MES +" TEXT, "+ CAMPO_NIVEL_ACTIVIDAD +" INTEGER, "
            + CAMPO_CALORIAS +" INTEGER, "+ CAMPO_CARBOHIDRATOS +" INTEGER, "+ CAMPO_PROTEINAS +" INTEGER, " + CAMPO_GRASAS +" INTEGER, "+ CAMPO_TIPO+" TEXT)";

    public static final String CREAR_TABLA_REGISTRO = "CREATE TABLE "+ TABLA_REGISTROS +" ("+ CAMPO_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CAMPO_FECHA +" TEXT, "+ CAMPO_TIPO_COMIDA +" TEXT, "+ CAMPO_ID_COMIDA +" TEXT)";

}
