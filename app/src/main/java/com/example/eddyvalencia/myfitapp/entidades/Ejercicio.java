package com.example.eddyvalencia.myfitapp.entidades;

public class Ejercicio {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer caloriasPerdidas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCaloriasPerdidas() {
        return caloriasPerdidas;
    }

    public void setCaloriasPerdidas(Integer caloriasPerdidas) {
        this.caloriasPerdidas = caloriasPerdidas;
    }

    public Ejercicio(){}

    public Ejercicio(Integer id, String nombre, String descripcion, Integer caloriasPerdidas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.caloriasPerdidas = caloriasPerdidas;
    }
}